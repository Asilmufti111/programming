import java.util.Scanner;

public class L11_Q5 {
    public static void main(String[] args) {
        
        Scanner input= new Scanner (System.in); 
        
        System.out.println ("Enter a number and it's width: ");
        int number=input.nextInt ();
        int width=input.nextInt ();
        System.out.println ("The format of the number is " + format (number, width));
    }

    public static String format (int number, int width) {

        String num =number+"";
        if (num.length () <width) {
            String zeros="";
            
            int numlength = num.length();
            while (width>numlength){
                zeros +="0";
                numlength++;
            }
            String format=zeros+num;
            return format;
        }
        else
            return num;

    }
    
}
