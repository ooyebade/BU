package oyebade.cs665;

public abstract class ParkingLot {

    Price price;

    public ParkingLot() {}

    public void showPrice() {
        price.getPricingStrategy();
    }

    public abstract void showMe();

    public void setPrice(Price price) {
        this.price = price;
    }
}

class ParkingSpotA extends ParkingLot {

    public ParkingSpotA() {
        price = new IncentiveBased();
    }

    @Override
    public void showMe() {
        System.out.println("Parking Spot A");
    }
}

class ParkingSpotB extends ParkingLot {

        public ParkingSpotB() {
            price = new IncentiveBased();
        }

        @Override
        public void showMe() {
            System.out.println("Parking Spot B");
        }
}

class ParkingSpotC extends ParkingLot {

    public ParkingSpotC() {
        price = new IncentiveBased();
    }

    @Override
    public void showMe() {
        System.out.println("Parking Spot C");
    }
}