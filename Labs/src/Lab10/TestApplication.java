package Lab10;

public class TestApplication {

    public static void main(String[] args) {
        basicVehicle vehicle = new Car(4, 5, 2, "Car");
        System.out.println(vehicle.toString());
        vehicle = new Bus(35, 6, 4, "Bus", "BOB ", "Smith");
        System.out.println(vehicle.toString());

    }

}
