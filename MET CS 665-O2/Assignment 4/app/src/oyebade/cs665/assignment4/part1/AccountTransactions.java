package oyebade.cs665.part1;

public class AccountTransactions {

    public static void main(String[] args) {

        Transaction transaction1 = new DepositTransaction();

        // printing out the deposit transaction statement
        System.out.println("--Testing Deposit Transaction by Itself--");
        System.out.println(transaction1.getDescription());
        System.out.print("\n");

        // printing out the deposit transaction with logging capability
        System.out.println("--Testing Deposit Transaction with Logging--");
        transaction1 = new LoggingDecorator(transaction1);
        System.out.println(transaction1.getDescription());
        System.out.print("\n");

        Transaction transaction2 = new DepositTransaction();
        // printing out the deposit transaction with security capability
        System.out.println("--Testing Deposit Transaction with Security--");
        transaction2 = new SecurityDecorator(transaction2);
        System.out.println(transaction2.getDescription());
        System.out.print("\n");

        // printing out the deposit transaction with logging and security capability
        System.out.println("--Testing Deposit Transaction with Logging and Security--");
        transaction2 = new LoggingDecorator(transaction2);
        System.out.println(transaction2.getDescription());
        System.out.print("\n");

        Transaction transaction3 = new WithdrawTransaction();

        // printing out withdraw transaction statement
        System.out.println("--Testing Withdraw Transaction--");
        System.out.println(transaction3.getDescription());
        System.out.print("\n");

        // printing out withdraw transaction with logging and security capability
        System.out.println("--Testing Withdraw Transaction with Security and Logging--");
        transaction3 = new LoggingDecorator(transaction3);
        transaction3 = new SecurityDecorator(transaction3);
        System.out.println(transaction3.getDescription());

        /*
        // practice tests
        Transaction transaction4 = new WithdrawTransaction();

        System.out.println("--Testing Withdraw Transaction with Security--");
        transaction4 = new SecurityDecorator(transaction4);
        System.out.println(transaction4.getDescription());

        Transaction transaction5 = new WithdrawTransaction();

        System.out.println("--Testing Withdraw Transaction with Logging--");
        transaction5 = new LoggingDecorator(transaction5);
        System.out.println(transaction5.getDescription()); **/
    }
}