package oyebade.cs665.part2;

public class SavingsAccount {

    CalculateInterest calculateInterest;

    public SavingsAccount(CalculateInterest calculateInterest) {

        this.calculateInterest = calculateInterest;
    }

    public void setCalculateInterest(CalculateInterest calculateInterest) {
        this.calculateInterest = calculateInterest;
    }

    public double callCalculateInterest(double balance, double rate) {
        return calculateInterest.calcInterest(balance, rate);
    }
}
