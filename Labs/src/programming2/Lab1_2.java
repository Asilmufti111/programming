package programming2;


import java.util.Scanner;

public class Lab1_2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of points: ");
        int pointsNum = input.nextInt();
        double[][] points = new double[pointsNum][2];

        System.out.println("Enter " + pointsNum + " points:");
        for (int i = 0; i < pointsNum; i++) {
            for (int j = 0; j < 2; j++) {
                points[i][j] = input.nextDouble();
            }

        }
        FindClosetTwoPoints(points);
    }

    public static void FindClosetTwoPoints(double[][] points) {
        double x1, x2, y1, y2;
        double X1 = 0, X2 = 0, Y1 = 0, Y2 = 0;
        //suppose that 10000000 is the closet points so it can enter the if statment for the first time 
        double ClosetTwoPoints = 10000000;
        for (int i = 0, j = 0; i < points.length-1; i++) {
                x1 = points[i][j];
                x2 = points[i + 1][j];
                y1 = points[i][j + 1];
                y2 = points[i + 1][j + 1];
                if (distance(x1, x2, y1, y2) < ClosetTwoPoints) {
                    ClosetTwoPoints=distance(x1, x2, y1, y2);
                    X1 = x1;
                    X2 = x2;
                    Y1 = y1;
                    Y2 = y2;
                

            }
        }
        System.out.println("The closest two points are (" + X1 + "," + Y1 + ") and (" + X2 + "," + Y2 + ")");

    }

    public static double distance(double x1, double x2, double y1, double y2) {
        double distance = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        return distance;
    }
}
