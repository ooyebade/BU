package oyebade.cs665;

interface Price {

    void getPricingStrategy();
}

class Standard implements Price {

    @Override
    public void getPricingStrategy() {
        System.out.println("This parking lot has a Standard Pricing Strategy");
    }
}

class PeakDemand implements Price {

    @Override
    public void getPricingStrategy() {
        System.out.println("This parking lot has a Peak-Demand Pricing Strategy");
    }
}

class IncentiveBased implements Price {

    @Override
    public void getPricingStrategy() {
        System.out.println("This parking lot has a Incentive-Based Pricing Strategy");
    }
}