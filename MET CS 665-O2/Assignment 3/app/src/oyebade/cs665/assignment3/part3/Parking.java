package oyebade.cs665.part3;

/**
 * show the Java code for creating the parking space objects
 * for different types of vehicles.
 * This should accommodate different vehicle types in the future.
 */
public class Parking {

    private static Parking parkingInstance;

    Parking() {}

    public static synchronized Parking getParkingInstance() {
        if (parkingInstance == null) {
            parkingInstance = new Parking();
        }
        return parkingInstance;
    }

    public ParkingSpace createParkingSpace(VehicleType vehicleType) {
        Parking parking = null;

        switch (vehicleType) {

            case CompactCar:

        }
        return null;
    }
}
