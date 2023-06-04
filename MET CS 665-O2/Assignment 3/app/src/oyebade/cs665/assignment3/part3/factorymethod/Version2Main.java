package oyebade.cs665.part3.factorymethod;

import oyebade.cs665.part3.*;


abstract class CustomerFactory {
    public abstract Customer createCustomer();
}

// standard customer factory class
class StandardCustomerFactory extends CustomerFactory {

    public Customer createCustomer() {
        // returning the standard customers
        return new StandardCustomer();
    }
}

// preferred customer factory class
class PreferredCustomerFactory extends CustomerFactory {

    public Customer createCustomer() {
        // returning the preferred customers
        return new PreferredCustomer();
    }
}

// business customer factory class
class BusinessCustomerFactory extends CustomerFactory {

    @Override
    public Customer createCustomer() {
        // returning the business customers
        return new BusinessCustomer();
    }
}

public class Version2Main {

    public static void main(String[] args) {

        System.out.println("Part 3 Second version using FactoryMethod\n");

        System.out.println("Creating " + CustomerType.Standard + " customer...");

        // creating a StandardCustomerFactory
        StandardCustomerFactory standardCustomerFactory = new StandardCustomerFactory();

        // creating standard customer using the factory method
        Customer sCustomer = standardCustomerFactory.createCustomer();
        System.out.println(sCustomer);

        System.out.println("Creating " + CustomerType.Preferred + " customer...");

        // creating a PreferredCustomerFactory
        PreferredCustomerFactory preferredCustomerFactory = new PreferredCustomerFactory();

        // creating preferred customer using the factory method
        Customer pCustomer  = preferredCustomerFactory.createCustomer();
        System.out.println(pCustomer);

        System.out.println("Creating " + CustomerType.Business + " customer...");

        // creating a BusinessCustomerFactory
        BusinessCustomerFactory businessCustomerFactory = new BusinessCustomerFactory();

        // creating business customer using the factory method
        Customer bCustomer = businessCustomerFactory.createCustomer();
        System.out.println(bCustomer);
    }
}