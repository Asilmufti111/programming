package Lab7;

import java.util.Scanner;

public class TestCylinder {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("***Cylinder***");
        System.out.println("--------------");
        
        System.out.println("Please, enter the cylinder's base radius:");
        double radius = input.nextDouble();
        System.out.println("--------------");

        System.out.println("Please, enter the cylinder's height:");
        double height = input.nextDouble();
        System.out.println("--------------");
        
        Cylinder c2 = new Cylinder(radius, height);
        System.out.println("Cylinder information:\n"
                + c2.toString());

    }

}
