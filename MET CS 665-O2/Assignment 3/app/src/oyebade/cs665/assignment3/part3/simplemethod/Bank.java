package oyebade.cs665.part3.simplemethod;

import oyebade.cs665.part3.*;

public class Bank {

    private static Bank bankInstance;

    Bank() {}

    public static synchronized Bank getBankInstance() {
        if (bankInstance == null) {
            bankInstance = new Bank();
        }
        return bankInstance;
    }

    public Customer createCustomer(CustomerType customerType) {

        Customer customer = null;

        // using the switch-case statement to show the types of customer
        switch (customerType) {
            // standard
            case Standard -> {
                customer = new StandardCustomer();
                break;
            }

            // preferred
            case Preferred -> {
                customer = new PreferredCustomer();
                break;
            }

            // business
            case Business -> {
                customer = new BusinessCustomer();
                break;
            }

            default ->
                    // exception
                    throw new IllegalArgumentException("Invalid customer type");
        }
        return customer;
    }
}
