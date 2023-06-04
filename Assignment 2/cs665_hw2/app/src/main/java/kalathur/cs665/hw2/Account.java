package kalathur.cs665.hw2;

import kalathur.cs665.hw2.enumTypes.AccountStatus;
import kalathur.cs665.hw2.exceptions.BankException;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public abstract class Account {

    private final String accountId;
    private final Date openDate;
    private Date closeDate;

    private final Customer primaryOwner;
    private Customer jointOwner;

    private AccountStatus accountStatus;

    private Date jointOwnershipDate;

    private int currentBalance;

    private final List<Transaction> transactionList;

    public Account(Customer primaryOwner, String accountId, Date openDate) {
        this.accountId = accountId;
        this.openDate = openDate;
        this.accountStatus = AccountStatus.Open;
        this.currentBalance = 0;
        this.transactionList = new ArrayList<>();
        this.primaryOwner = primaryOwner;
        primaryOwner.addAccount(this);
    }

    public Customer getPrimaryOwner() {
        return this.primaryOwner;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public Date getOpenDate() {
        return this.openDate;
    }

    public AccountStatus getAccountStatus() {
        return this.accountStatus;
    }

    public int getCurrentBalance() {
        return this.currentBalance;
    }

    public void setJointOwner(Customer jointOwner, Date jointOwnershipDate) {
        this.jointOwner = jointOwner;
        this.jointOwnershipDate = jointOwnershipDate;
        jointOwner.addAccount(this);
    }

    public Customer getJointOwner() {
        return this.jointOwner;
    }

    public Date getJointOwnershipDate() {
        return this.jointOwnershipDate;
    }

    protected synchronized void addTransaction(Transaction t) {

        if (this.accountStatus == AccountStatus.Close)
            throw new BankException("Account " + this.getAccountId() + "closed... Transaction not allowed");

        if (t instanceof DepositTransaction) {

            // making transaction of the DepositTransaction type
            DepositTransaction dt = (DepositTransaction) t;
            // invoking the deposit method with the transaction amount
            deposit(dt.getTransactionAmount());
            // adding the transaction to the transactionList
            transactionList.add(dt);
            // setting the ending balance of the transaction as the account's current balance
            dt.setEndingBalance(currentBalance);
            // calling the transaction's print() method
            dt.print(this);

        } else if (t instanceof WithdrawTransaction) {

            // making transaction of the WithdrawTransaction type
            WithdrawTransaction wt = (WithdrawTransaction) t;
            // using the if-else statement to compare the transactionAmount with the current balance
            // if the transaction amount is less than or equal to the current balance
            if (wt.getTransactionAmount() <= currentBalance) {
                // then withdrawing only
                withdraw(wt.getTransactionAmount());
            } else {
                // otherwise, change the description of the transaction
                wt.setDescription("Not enough balance, withdrawal ignored " + this.getAccountId());
            }
            // adding the transaction to the transactionList
            transactionList.add(wt);
            // setting the ending balance of the transaction as the account's current balance
            wt.setEndingBalance(currentBalance);
            // calling the transaction's print() method
            wt.print(this);

        } else if (t instanceof TransferTransaction) {

            TransferTransaction tr = (TransferTransaction) t;

            if (tr.getToAccount().accountStatus == AccountStatus.Close)
                throw new BankException("Account " + this.getAccountId() + " closed... Transaction not allowed");

            tr.setDescription("Transfer from " + this.getAccountId() + " to " + tr.getToAccount().getAccountId());
            this.transactionList.add(tr);
            tr.getToAccount().transactionList.add(tr);
            tr.print(null);
        }

    }

    private synchronized void deposit(int amount) {
        this.currentBalance += amount;
    }

    private synchronized void withdraw(int amount)  {
        this.currentBalance -= amount;
    }

    public synchronized void closeAccount(Date closeDate) {
        this.accountStatus = AccountStatus.Close;
        this.closeDate = closeDate;
    }

    public void printStatement(Date toDate) {

        System.out.println("\n\tTransactions for Account " + this.accountId + " Primary Owner: " + this.primaryOwner.getName() + "\n");

        // using the for-loop to iterate over the transactionList
        for (Transaction t : transactionList) {
            // calling the print() method with each of the transaction
            t.print(this);
        }

    }

}


