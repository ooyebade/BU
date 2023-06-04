package oyebade.cs665.part2;

public class CompoundedInterest implements CalculateInterest {

    @Override
    public double calcInterest(double balance, double rate) {
        return (balance * Math.pow((1 + rate / 365),31) - balance);
    }
}
