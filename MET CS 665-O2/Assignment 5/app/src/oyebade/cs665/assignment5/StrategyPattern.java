package oyebade.cs665;

public class StrategyPattern {

    public static void main(String[] args) {

        ParkingLot parkingLotContext = new ParkingSpotA();
        parkingLotContext.showMe();
        parkingLotContext.showPrice();

        System.out.println("--------------");

        parkingLotContext = new ParkingSpotB();
        parkingLotContext.showMe();
        parkingLotContext.showPrice();

        System.out.println("--------------");

        parkingLotContext = new ParkingSpotC();
        parkingLotContext.showMe();
        parkingLotContext.showPrice();


        System.out.println("--------------");

        parkingLotContext.setPrice(new IncentiveBased());
        parkingLotContext.showPrice();
    }
}
