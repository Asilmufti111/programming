/* Course : CPCS 202
Problem number : 1 (2987)
Assignment number : 4
Link to your beecrowd/URI profile :https://www.beecrowd.com.br/judge/en/profile/587463
Link to your Codechef profile :https://www.codechef.com/users/asil2106122/edit
*/

import java .util.Scanner;
 
public class Problem_1 {
 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // take a single character from the user , an uppercase letter ('A' - 'Z') of the alphabet.
        char inChar= input.next().charAt(0);
        // call getPositionOfChar method and print the position of the letter in the alphabet.
        System.out.println(getPositionOfChar(inChar));
    }
    // a method to calculate and return the position of the alphabet character
    public static int getPositionOfChar(char inChar){
        int position=0;
        for (int i ='A'; i<=inChar; i++){
            position++;
        }
        return position;
    }
 
}