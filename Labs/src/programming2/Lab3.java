package programming2;


import java.io.*;
import java.util.Scanner;

public class Lab3 {

    public static void main(String[] args) throws FileNotFoundException {

        File file1 = new File("file1.txt");
        if (!file1.exists()) {
            System.out.println("File does not exists");
            System.exit(0);
        }
        Scanner input = new Scanner(file1);

        File file2 = new File("file2.txt");

        PrintWriter output = new PrintWriter(file2);
        Scanner input1 = new Scanner(file2);

        while (input.hasNext()) {
            String x = input.next();
            output.print(x.replaceAll("\\D+", " "));

        }
        input.close();
        output.close();

        while (input1.hasNext()) {
            boolean prime = true;
            int num = input1.nextInt();
            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0) {
                    prime = false;

                }
            }
            if (prime) {
                System.out.print(num + " ");
            }

        }
        input1.close();

    }

}
