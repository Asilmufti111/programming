
import java.util.Scanner;

public class Recursion_lab5 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of the program (from 1 to 4):");
        int program = in.nextInt();

        if (program == 1) {
            System.out.println("Enter the number: ");
            int num = in.nextInt();
            int sum = 0;
            if (num % 2 == 0) {
                sum = sumEvenNums(num);
            } else {
                sum = sumEvenNums(num - 1);
            }
            System.out.println("The sum of all even intgers from 1 to " + num + " is: " + sum);

        } else if (program == 2) {
            System.out.println("Enter the number: ");
            int num = in.nextInt();
            int sub = subNums(num);
            System.out.println("The difference of all intgers from 1 to " + num + " is: " + sub);

        } else if (program == 3) {
            System.out.println("The array before reversing: ");
            int arr[] = {1, 2, 3, 4, 5};
            for (int i = 0; i < arr.length; ++i) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();

            ArrayReverse(arr, 0, arr.length - 1);
            for (int i = 0; i < arr.length; ++i) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();

        } else if (program == 4) {
            System.out.println("Enter the number: ");
            String num = in.next();
            RevIntRecursive(num);
            System.out.println();
        }
    }

    public static int sumEvenNums(int num) {
        if (num <= 1) {
            return 0;
        } else {
            return num + sumEvenNums(num - 2);
        }

    }

    public static int subNums(int num) {
        if (num == 1) {
            return 1;

        } else {
            return subNums(num - 1) - num;
        }
    }

    public static void ArrayReverse(int[] arr, int beg, int end) {
        if (beg > end) {
            System.out.println("The array after reversing: ");

        } else {
            int temp = arr[beg];
            arr[beg] = arr[end];
            arr[end] = temp;
            ArrayReverse(arr, ++beg, --end);
        }

    }

    public static void RevIntRecursive(String num) {
        if (num.length() != 0) {
            RevIntRecursive(num.substring(1));
            System.out.print(num.charAt(0));

        }
    }
}
