package second;
//import java.lang.ArithmeticException;

public class RethrowingExceptions {

    public static void main(String[] args) {
        System.out.println("Start of main()");
        try {
            divide();
        } catch (ArithmeticException e) {
            System.out.println("Rethrown Exception Caught in Main()");
            System.out.println(e.getMessage());
        }
    }

    static void divide() {
        int x, y, z;
        try {
            x = 6;
            y = 0;
            z = x / y;
            System.out.println(x + "/" + y + "=" + z);
        } catch (ArithmeticException e) {
            System.out.println("Exception Caught in Divide()");
            System.out.println("Cannot Divide by Zero in Integer Division");
            throw e; // Rethrows an exception
        }

    }

}
