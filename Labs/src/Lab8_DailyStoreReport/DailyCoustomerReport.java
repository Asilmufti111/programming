package Lab8_DailyStoreReport;

import java.util.*;

public class DailyCoustomerReport {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of customers for the current day:");
        int customersNumber = input.nextInt();
        line();

        Customer[] costomers = new Customer[customersNumber];
        for (int i = 0; i < customersNumber; i++) {
            System.out.println("Enter customer's name:");
            String name = input.next();
            System.out.println("Enter customer's Purchases Cost:");
            int cost = input.nextInt();
            System.out.println("Enter customer's type (V for VIP, R for Regular and N for New):");
            String type = input.next();
            line();

            if (type.equals("v") || type.equals("V")) {
                costomers[i] = new VIP(name, cost);

            } else if (type.equals("r") || type.equals("R")) {
                costomers[i] = new Regular(name, cost);

            } else {
                costomers[i] = new New(name, cost);
            }

        }
        for (int i = 0; i < customersNumber; i++) {

            if (costomers[i] instanceof VIP) {
                if (((VIP) costomers[i]).GiftCertivacate() != 0) {
                    System.out.println("Congratulation for the next customer. You Won 100.0 SR. gift certificate");
                }
                System.out.println(costomers[i].toString());

            } else if (costomers[i] instanceof Regular) {
                System.out.println(costomers[i].toString());

            } else {
                System.out.println("New " + costomers[i].toString());
            }

        }
        line();
        double total = 0;
        for (int i = 0; i < customersNumber; i++) {
            total += costomers[i].getPurchasesCost();
        }
        System.out.println("Current day income = " + total + "SR.");
        line();
    }

//------------------------------------------------------------------------
    public static void line() {
        System.out.println("--------------------------------------------------------------------");

    }
}
