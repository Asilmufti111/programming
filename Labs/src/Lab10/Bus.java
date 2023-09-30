package Lab10;

public class Bus extends basicVehicle {

    private String driverName;

    public Bus(int noOfWheels, int noOfSeats, int noOfDoors, String type, String driverFName, String driverLName) {
        super(noOfWheels, noOfSeats, noOfDoors, type);
        this.driverName = driverFName + driverLName;
    }

    public void setDriverName(String driverFName, String driverLName) {
        this.driverName = driverFName + driverLName;
    }

    public String getDriverName() {
        return driverName;
    }

    @Override
    public String toString() {
        return super.toString() + "\nDriver : " + driverName;
    }

}
