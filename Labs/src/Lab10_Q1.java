import java.util.Scanner;

public class Lab10_Q1 {

    public static void main(String[] args) {
       Scanner input = new Scanner (System.in);
       System.out.println("Enter a string:");
       //take a string from the user 
       String s = input.nextLine();
       System.out.println("The number of letters are:"+ countLetters(s));

       
    }
    public static int countLetters(String s){
        int length =s.length();
        int letters_num=0;
        for (int i = 0 ; i<length ;i++){
            if (Character.isLetter(s.charAt(i))){
                letters_num++;    
            }
        }
        return letters_num;
    
    }
}
