package oyebade.cs665.part2;

public class SimpleInterest implements CalculateInterest{

    @Override
    public double calcInterest(double balance, double rate) {
        return (balance * rate / 12.0);
    }
}
