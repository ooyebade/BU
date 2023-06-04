package oyebade.cs665.part2;

public class InterestAccount {

    public static void main(String[] args) {

        SavingsAccount savingsAccount = new SavingsAccount(new SimpleInterest());

        System.out.println("Using Simple Interest: ");
        System.out.println(savingsAccount.callCalculateInterest(1000000, 0.02));

        savingsAccount.setCalculateInterest(new CompoundedInterest());
        System.out.println("Using Compound Interest:");
        System.out.println(savingsAccount.callCalculateInterest(1000000, 0.02));
    }
}
