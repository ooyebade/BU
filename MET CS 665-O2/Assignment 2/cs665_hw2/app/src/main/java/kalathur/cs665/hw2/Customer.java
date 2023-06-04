package kalathur.cs665.hw2;

import java.text.DateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private final String name;
    private final String customerId;
    private final Date registrationDate;
    private final List<Account> accountList;

    public Customer(String name, String customerId, Date registrationDate) {
        this.name = name;
        this.customerId = customerId;
        this.registrationDate = registrationDate;
        this.accountList = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public Date getRegistrationDate() {
        return this.registrationDate;
    }

    public void addAccount(Account account) {

        // if the account is not presenting then add it
        if(!accountList.contains(account))
            accountList.add(account);
    }


    public void printStatement(Date toDate) {

        System.out.println("\nBEGIN ACCOUNT STATEMENT - " + this.getName() + " - " + DateFormat.getDateInstance().format(toDate));

        // using the for loop to iterate through the accounts
        for (Account acc: accountList) {
            // printing each statement for each account
            acc.printStatement(toDate);
        }


        System.out.println("\nEND ACCOUNT STATEMENT\n");
    }


}
