// import the packakge

import java.util.Scanner;
import java.util.InputMismatchException;

public class ExceptionTest {

    public static String lessThan100(int number) throws Exception {

        if (number >= 100) {
            // write a statement to throws the exception that the number is to large
            throw new Exception("Number too large");
        }

        // Return the number if the number is less than 100
        return "The number " + number + " is less than 100";
    }

    public static String lessThan50(int number) throws Exception {

        if (number >= 50 && number < 100) {
            //write a statement to throws the exception that the number is between 50 and 100."
            throw new Exception("the number is between 50 and 100");
        } else if (number >= 100) {
            System.out.println(lessThan100(number));
        }

        // Return the number if the number is less than 50
        return "The number " + number + " is less than 50";
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        // input the number from user in the  try block  
        try {
            System.out.println("Enter an integer: ");
            int number = input.nextInt();
            System.out.println(lessThan100(number));
        } // write the catch  (InputMismatchException, Exception)
        catch (InputMismatchException e) {
            System.out.println(e);

        } catch (Exception e) {
            System.out.println(e);
        }
    } //  end main method
}
