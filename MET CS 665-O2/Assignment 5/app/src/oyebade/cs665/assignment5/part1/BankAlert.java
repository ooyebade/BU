package oyebade.cs665.part1;

public class BankAlert {

    public static void main(String[] args) {

        // bank subject for promotional offers
        BankSubject bs1 = new BankSubject();

        System.out.println("Promotional Information Message by Navy Federal Credit Union");
        System.out.print("\n");

        // creating the two observers for promotional offers
        BankObserver bankObserver1 = new BankObserver("Patty");
        BankObserver bankObserver2 = new BankObserver("Roman");

        // register the observers
        bs1.attach(bankObserver1);
        bs1.attach(bankObserver2);

        // setting the observer promotional info value
        bs1.setValue("New Deals for Auto Loans Refinance...");

        // removing the value set for the observer
        bs1.detach(bankObserver1);
        bs1.detach(bankObserver2);

        // setting a new value
        //bs1.setValue("Increase interest rate...");

        System.out.print("\n");

        // bank subject for product information alerts
        BankSubject bs2 = new BankSubject();

        System.out.println("Product Information Message by Bank of America");
        System.out.print("\n");

        // creating the two observers for Product Info
        BankObserver bankObserver3 = new BankObserver("David");
        BankObserver bankObserver4 = new BankObserver("Mary");

        // registering the observer
        bs2.attach(bankObserver3);
        bs2.attach(bankObserver4);

        // setting the observer product info value
        bs2.setValue("Interest rate being increased...");

        // removing the value set for the observer
        bs2.detach(bankObserver1);
        bs2.detach(bankObserver2);
    }
}