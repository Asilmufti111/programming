import java.util.Scanner;
public class Lab5Activity {

    public static void main(String[] args) {
        Scanner input= new Scanner (System.in);
        System.out.println("please enter 0 to convert from U.S dollars to Saudi SAR and 1 to convert from Saudi SAR to U.S dollars:");
        double num = input.nextDouble();
                
        if (num == 0){
            System.out.println("please enter the amount in U.S dollars: ");
            double amount = input.nextDouble();

            amount = amount * 3.75;
            System.out.println("the exchange in Saudi SAR is: " + amount);
        }
        else if (num == 1) {
            System.out.println("please enter the amount in Saudi SAR: ");
            double amount = input.nextDouble();
             amount = amount / 3.75;
             System.out.println("the exchange in U.S dollars is: " + amount);
        }
        else 
            System.out.println("wrong input, please enter just 0 or 1. ");
    }
    
}
