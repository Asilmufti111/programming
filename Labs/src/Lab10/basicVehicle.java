package Lab10;

public abstract class basicVehicle implements Vehicle {

    private int noOfWheels;
    private int noOfSeats;
    private int noOfDoors;
    private String type;

    public basicVehicle(int noOfWheels, int noOfSeats, int noOfDoors, String type) {
        this.noOfWheels = noOfWheels;
        this.noOfSeats = noOfSeats;
        this.noOfDoors = noOfDoors;
        this.type = type;
    }

    public int getNumberOfDoors() {
        return noOfDoors;
    }

    @Override
    public String toString() {
        return "Type: " + type + "\n# Of Wheels: " + noOfWheels + "\n# of Seats: " + noOfSeats + "\n# of Doors: " + noOfDoors;
    }

}
