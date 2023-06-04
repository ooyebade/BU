package oyebade.cs665.part3.simplemethod;

import oyebade.cs665.part3.*;

public class Version1Main {
    public static void main(String[] args) {

        Bank bank = Bank.getBankInstance();

        System.out.println("Part 3 First version using SimpleFactory\n");

        System.out.println("Creating " + CustomerType.Standard + " customer...");

        StandardCustomer standardCustomer = (StandardCustomer) bank.createCustomer(
                CustomerType.Standard);
        System.out.println(standardCustomer);

        System.out.println("Creating " + CustomerType.Preferred +  " customer...");

        PreferredCustomer preferredCustomer = (PreferredCustomer) bank.createCustomer(
                CustomerType.Preferred);
        System.out.println(preferredCustomer);

        System.out.println("Creating " + CustomerType.Business + " customer...");

        BusinessCustomer businessCustomer = (BusinessCustomer) bank.createCustomer(
                CustomerType.Business);
        System.out.println(businessCustomer);
    }
}
