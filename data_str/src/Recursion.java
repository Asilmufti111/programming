
//course number: CPCS204
//Assigment title: Recursion
//Assigment date: thursday oct 27, 2022
import java.io.*;
import java.util.*;

public class Recursion {

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("input.txt");//create a file object to read from input file

        if (!inputFile.exists()) { //check that the file is exist
            System.out.println("The intial Information file does not exist");//display that the file does not exist
            System.exit(0);//exit from the program
        }

        Scanner input = new Scanner(inputFile);//craete a scanner object to read by it from input file
        File outputFile = new File("output.txt");//create a file object to write the output in it
        PrintWriter output = new PrintWriter(outputFile); //craete a PrintWriter object to write by it in  the output file

        int commandNum = input.nextInt();//take the number of commands from the input file 
        for (int i = 0; i < commandNum; ++i) {//Enter the loop by the number of commands times
            String command = input.next();//reead the command that we sould do 

            if (command.equals("charPattern")) {//check the contents of the command
                char c = input.next().charAt(0);//read a charecter from the input file
                output.println(characterPattern(c));//implement the command and print the result on output file

            } else if (command.equals("drawDiamond")) {//check the contents of the command
                int num = input.nextInt();//read an integer number from the input file
                diamondShape(num, 1, output);//implement the command

            } else if (command.equals("bricksToUnload")) {//check the contents of the command
                int num = input.nextInt();//read an integer number from the input file
                output.println(throwBricks(num));//implement the command and print the result on output file
            }
        }

        output.flush();//print everything now 
        output.close();//close the output file 
    }

    //recursive method to implement (characterPattern) command
    public static String characterPattern(char c) {//the method take 1 parameter
        if (c == 'A') {//the base case for the recursive method is reaching to the first letter (char)
            return "A";//return (A) which is the first char 
        }

        return characterPattern((char) ((int) c - 1)) + c + characterPattern((char) ((int) c - 1));// call the method recursivly

    }

    //recursive method to implement (diamondShape) command
    public static void diamondShape(int max, int stars, PrintWriter output) {//the method take 3 parameter
        if (stars <= max) {// the base case is (stars>max) 

            int space = max - stars;// the number of the spaces before the stars
            for (int i = 0; i < space; ++i) {//for loop to print the spaces 
                output.print(" ");//printing spaces 
            }

            for (int j = 0; j < stars; j++) {// for loop to print the stars
                output.print("* ");//printing stars
            }

            output.println();//print new line after each row of stars 

            diamondShape(max, stars + 2, output);//calling the method recursivly

            if (stars != max) {//to not print the max number of stars twice

                for (int i = 0; i < space; ++i) {//for loop to print the spaces 
                    output.print(" ");//printing spaces 
                }

                for (int j = 0; j < stars; j++) {// for loop to print the stars
                    output.print("* ");//printing stars
                }

                output.println();//print new line after each row of stars 

            }
        }
    }

    //recursive method to implement (throwBricks) command
    public static int throwBricks(int num) {//the method take 1 parameter
        if (num <= 1) {//base case equle or less than 1
            return 1;
        }
        if (num == 2) {//base case 2
            return 2;
        }

        return throwBricks(num - 1) + throwBricks(num - 2) + throwBricks(num - 3);// call the method recursivly

    }
}
