
import java.util.*;

public class ArrayExercises_lab1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int r = input.nextInt();
        System.out.println();
        System.out.println("Enter number of columns: ");
        int c = input.nextInt();
        System.out.println();

        int[][] arr = new int[r][c];

        System.out.println("Entering random numbers in matrix of " + r + " rows and " + c + " columns: \n"
                + "The array elements are as follows: \n");
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = (int) (Math.random() * 100);

                System.out.print(arr[i][j] + "\t");
            }
            System.out.println("\n");
        }

        int counter = 0;
        for (int i = 0; i < r; ++i) {
            counter = RepeatedElementsRow(i, arr, counter);
        }
        if (counter == 0) {
            System.out.println("No row contains duplicate elements");
        }
    }

    public static int RepeatedElementsRow(int i, int arr2[][], int counter) {
        boolean flag = false;
        for (int j = 0; j < arr2.length && !flag; j++) {
            for (int k = 0; k < arr2.length; k++) {
                if (k != j && arr2[i][j] == arr2[i][k]) {
                    flag = true;
                    break;
                }
            }

        }

        if (flag) {
            counter++;
            if (counter == 1) {
                System.out.println("Row(s) containing repeated elements");
            }

            for (int j = 0; j < arr2.length; j++) {
                System.out.print("\t" + arr2[i][j]);
            }
            System.out.println();
        }
        return counter;
    }

}
