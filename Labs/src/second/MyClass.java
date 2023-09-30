package second;

public class MyClass {

    public static void main(String args[]) {
        try {
            throw new Exception("Error in method m");
        } catch (Exception ex) {

            System.out.println("+\n-------printStackTrace<)-------" + "\n");

            System.out.println("------getMessage-----");
            System.out.println("\n" + ex.getMessage() + "\n");
            ex.printStackTrace();

            System.out.println("---------toString()-------");
            System.out.println("\n" + ex.toString() + "\n");
            ex.printStackTrace();

        }
    }
}
