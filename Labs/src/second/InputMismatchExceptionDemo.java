package second;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputMismatchExceptionDemo {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean continuelnput = true;
        do {
            try {
                System.out.print("Enter an integer: ");
                int number = input.nextInt();
// Display the result
                System.out.println("The number entered is " + number);
                continuelnput = false;
            } catch (InputMismatchException ex) {
                System.out.println("Try again. (");
                input.nextLine(); // discard input
            }
        } while (continuelnput);
    }
}
