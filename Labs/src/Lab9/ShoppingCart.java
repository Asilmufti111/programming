package Lab9;

import java.util.*;

public class ShoppingCart {

    public static void main(String[] args) {
        ArrayList<Items> cart = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.println("Enter the name of the item: ");
            String name = input.nextLine();
            System.out.println("Enter the unit price: ");
            double price = input.nextDouble();
            System.out.println("Enter the quantity: ");
            int quantity = input.nextInt();

            cart.add(new Items(name, price, quantity));

            System.out.println("Continue shopping (y/n)? ");
            String Continue = input.next();
            if (Continue.equals("n")) {
                break;
            }
            input.nextLine();//to read the end of the line 
        }

        System.out.println("\nFinal Shopping Cart totals");
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("%-15s%-15s%-15s%-15s\n", "ItemName", "Unit price", "Quantity", "price * quantity");

        double totalOfeachItem = 0;
        double total = 0;
        for (int i = 0; i < cart.size(); i++) {
            totalOfeachItem = cart.get(i).getUnitPrice() * cart.get(i).getQuantity();
            System.out.printf("%-15s%-15s%-15s%-15s\n", cart.get(i).getItemName(), cart.get(i).getUnitPrice(), cart.get(i).getQuantity(), totalOfeachItem);
            total += totalOfeachItem;
        }

        System.out.println("Total amount in the cart " + total + " SR");
    }
}
