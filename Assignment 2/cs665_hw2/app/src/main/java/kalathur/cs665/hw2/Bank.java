package kalathur.cs665.hw2;

import kalathur.cs665.hw2.enumTypes.AccountType;
import kalathur.cs665.hw2.enumTypes.TransactionType;
import kalathur.cs665.hw2.exceptions.BankException;

import java.util.HashMap;
import java.util.Map;
import java.util.Date;

public class Bank {

    private final Map<String, Customer> customerMap;
    private final Map<String, Account> accountMap;

    private static Bank bankInstance;

    private Bank() {
        customerMap = new HashMap<>();
        accountMap  = new HashMap<>();
    }

    public static synchronized Bank getBankInstance() {
        if (bankInstance == null) {
            bankInstance = new Bank();
        }
        return bankInstance;
    }

    /**
     * This method creates a new customer
     * @param customerName represents the customer name
     * @param customerId represents the ID of the customer
     * @param registrationDate represents the date in which the customer registers
     * @return the customer
     * @throws BankException
     */
    public synchronized Customer createCustomer(String customerName, String customerId, Date registrationDate)
            throws BankException {

        // using the if-else statement to see if the customer ID already exists
        if(customerMap.containsKey(customerId)) {
            // return that the customer already exists
            throw new BankException("Customer Already Exists");
        }
        else {
            // putting the new customer in a customerMap
            customerMap.put(customerId, new Customer(customerName, customerId, registrationDate));
            // return that customer
            return customerMap.get(customerId);
        }
        // return null;
    }

    /**
     * This method is looking up the customer ID
     * @param customerId represents the customer ID
     * @return the customer
     * @throws BankException
     */
    public synchronized Customer lookupCustomer(String customerId) throws BankException {

        // using the if-else statement to see if the customer ID does not exist
        if(!customerMap.containsKey(customerId)) {
            // return that the customer doesn't exist
            throw new BankException("Customer Does Not Exist");
        }
        else {
            // getting the customer using its customerId
            return customerMap.get(customerId);
        }
        // return null;
    }

    /**
     * This method will be creating a new account
     *
     * @param customerId represents the customer id
     * @param accountType represents the type of account the customer has
     * @param accountId represents the customer accounts id
     * @param openDate represents the date of which the customer opens the account
     * @param initialAmount represents the initial amount of the customer
     * @return
     * @throws BankException
     */
    public synchronized Account createAccount(String customerId, AccountType accountType,
                                              String accountId, Date openDate, int initialAmount)
            throws BankException {

        // checking for the account type
        // if the account type is neither checking nor savings
        if(accountType != AccountType.Checking && accountType != AccountType.Savings) {
            // then throw an error
            throw new BankException("Invalid Account Type");
        }
        // checking to see if that account already exists
        else if(accountMap.containsKey(accountId)) {
            // if it exists then throw an error
            throw new BankException("Account already exists");
        } else {
            // putting the newly created account into an accountMap
            if (accountType == AccountType.Savings) {
                accountMap.put(accountId, new SavingsAccount(customerMap.get(customerId), accountId, openDate, initialAmount));
            }
            else {
                accountMap.put(accountId, new CheckingAccount(customerMap.get(customerId), accountId, openDate, initialAmount));
            }
            // then return the account using the account id
            return accountMap.get(accountId);
        }
        // return null;
    }

    /**
     * This method will be looking up the account
     * @param accountId represents the account id
     * @return the account
     */
    public synchronized Account lookupAccount(String accountId) {

        // using try-catch to check whether the account doesn't exist
        try {
            // if the account does not exist
            if(!accountMap.containsKey(accountId))
                // then throw an error
                throw new BankException("Account Doesn't Exist");
            // otherwise, return the account using the account id
            return accountMap.get(accountId);
        } catch (Exception err) {}
        return null;
    }

    public synchronized void setJointOwner(String accountId, String primaryOwnerId,
                                           String jointOwnerId, Date jointOwnershipDate) {

        Account account = this.lookupAccount(accountId);
        Customer primaryOwner = this.lookupCustomer(primaryOwnerId);
        Customer jointOwner   = this.lookupCustomer(jointOwnerId);

        if ((account != null) && (primaryOwner != null) && (jointOwner != null)) {
            if ( (account.getPrimaryOwner() == primaryOwner) && (account.getJointOwner() == null) ) {
                account.setJointOwner(jointOwner, jointOwnershipDate);
            }
        }


    }

    public synchronized void createTransaction(TransactionType transactionType, Date date, int amount,
                                               String customerId, String sourceAccountId,
                                               String destinationAccountId) {

        switch (transactionType) {
            // if the transaction type is deposit
            case Deposit -> {
                makeDeposit(date, amount, customerId, sourceAccountId);
                break;
            }
            // if the transaction type is withdraw
            case Withdraw -> {
                makeWithdrawal(date, amount, customerId, sourceAccountId);
                break;
            }
            // if the transaction type is transfer
            case Transfer -> {
                makeTransfer(date, amount, customerId, sourceAccountId, destinationAccountId);
            }
        }
    }

    /**
     *
     * @param date represents the date
     * @param amount represents the amount
     * @param customerId representing the customer id
     * @param accountId representing the account id
     */
    private synchronized void makeDeposit(Date date, int amount, String customerId, String accountId) {
        Customer customer = this.lookupCustomer(customerId);
        Account account = this.lookupAccount(accountId);
        new DepositTransaction(date, amount, customer, account);
    }

    private synchronized void makeWithdrawal(Date date, int amount, String customerId, String accountId) {
        Customer customer = this.lookupCustomer(customerId);
        Account account = this.lookupAccount(accountId);
        if (account != null &&
                ((account.getPrimaryOwner() == customer) ||
                        (account.getJointOwner() != null && account.getJointOwner() == customer)) ) {
            new WithdrawTransaction(date, amount, customer, account);
        } else
            new BankException("Customer is not owner or joint owner");
    }

    private synchronized void makeTransfer(Date date, int amount, String customerId, String fromAccountId, String toAccountId) {
        Customer customer = this.lookupCustomer(customerId);
        Account fromAccount = this.lookupAccount(fromAccountId);
        Account toAccount = this.lookupAccount(toAccountId);
        if (fromAccount != null &&
                ((fromAccount.getPrimaryOwner() == customer) ||
                        (fromAccount.getJointOwner() != null && fromAccount.getJointOwner() == customer)) ){
            new TransferTransaction(date, amount, customer, fromAccount, toAccount);
        } else
            new BankException("Customer is not owner or joint owner");
    }

    public synchronized void printStatement(String customerId, Date toDate) {
        Customer customer = this.lookupCustomer(customerId);
        if (customer != null)
         customer.printStatement(toDate);
    }

}
