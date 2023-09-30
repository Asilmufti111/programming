
import java.util.Scanner;


public class Pastry_Shop {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int totalWQ = 0, totalPQ = 0, totalCQ = 0;
        int Wprice = 0, Pprice = 0, Cprice = 0;
           String name; char selection;
        do {
            System.out.println("-----------------------------------------");
            System.out.println("Welcom to Asil Pastry Shop");
            System.out.println("-----------------------------------------");
            System.out.println("W: Waffle \t \t  15 SR");
            System.out.println("P: Pancake \t \t  12 SR");
            System.out.println("C: Cupcake \t \t   6 SR");
            System.out.println("B: Buy and Exit ");
            System.out.println("-----------------------------------------");

            System.out.println("Enter your selection: ");
             selection = input.next().charAt(0);
             selection= Character.toUpperCase(selection);
            switch (selection) {
                case 'W':
                    Wprice = 15;
                    System.out.println("Quantity: ");
                    int WQ = input.nextInt();
                    totalWQ += WQ;
                                        break;

                case 'P':
                    Pprice = 12;
                    System.out.println("Quantity: ");
                    int PQ = input.nextInt();
                    totalPQ += PQ; 
                    break;

                case 'C':
                    Cprice = 6;
                    System.out.println("Quantity: ");
                    int CQ = input.nextInt();
                    totalCQ += CQ;
                                        break;


                case 'B': {
                    if (totalWQ == 0 && totalPQ == 0 && totalCQ == 0) {
                        System.out.println("Your cart is empty.");
                        break;
                    } else {
                        do {
                            System.out.println("Enter your name(must be only letters with more that 2 character): ");
                             name = input.nextLine();

                        } while (isCOrrectName(name) == false);

                         
                        System.out.println("Hi " + name);
                        System.out.println("-------------------Details---------------");
                        System.out.println("Item \t Quantity \t Price ");
                        int totalWprice = Wprice * totalWQ;
                        System.out.println("Waffle \t" + totalWQ + totalWprice);
                        int totalPprice = Pprice * totalPQ;

                        System.out.println("Pancake \t" + totalPQ + totalPprice);
                        int totalCprice = Cprice * totalCQ;

                        System.out.println("Cupcake \t" + totalCQ + totalCprice);
                        System.out.println("-----------------------------------------");
                        int Subtotal = (totalWprice + totalWprice + totalCprice);
                        System.out.println("Subtotal: " + Subtotal);
                        System.out.println("Enter Discount value: ");
                        int discount = input.nextInt();
                        double totalprice = (Subtotal - (calculatediscount(Subtotal, discount)));
                        System.out.println("Total price: " + totalprice + " SAR");
                        System.out.println("-----------------------------------------");
                        if (totalprice > 100) {
                            System.out.println("Your Copon for the next visit " + copon(name));
                        }

                        System.out.println("Have a nice day! ");
                    break;

                    }
                }
                default:
                    System.out.println("Not Avalible! Try again ");

            }
        } while (selection != 'B');

        
    

    }

public static boolean isCOrrectName(String name){
        if (name.length()>2){
            for (int i =0; i<name.length();i++){
                if (Character.isLetter(name.charAt(i))== false);
        return false;
                }}
        return true;
    }
        public static double calculatediscount(int Subtotal,  int discount){
            double dicountvalue=Subtotal*(discount/100.0);
            return dicountvalue;
        }
                public static String copon(String name){
                    char firstL=name.charAt(0);
                                        char secondL=name.charAt(1);
                                        int randome=(int)(Math.random()*900)+100;
                                        return (firstL + secondL +""+randome);

                }


}
    
