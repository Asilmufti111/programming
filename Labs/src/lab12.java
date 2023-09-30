
import java.util.Scanner;

public class lab12 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter 10 num : ");

        int[] list = new int[10];
        int count = 0;
        for (int i = 0; i < 10; i++) {
            int num = input.nextInt();
            if (notfind(num, list)) {
                list[count] = num;
                count++;
            }

        }
        System.out.println("num of distinct num:" + count);

        System.out.print("the distinct num are : ");
        for (int i = 0; i < list.length; i++) {
            if(list[i]!=0)
            System.out.print(list[i] + " ");
        }
    }

    public static boolean notfind(int num, int[] list) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == num) {
                return false;

            }

        }           return true;

    }

}
