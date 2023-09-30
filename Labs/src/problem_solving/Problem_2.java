/* Course : CPCS 202
Problem number : 2 (2862)
Assignment number : 4
Link to your beecrowd/URI profile :https://www.beecrowd.com.br/judge/en/profile/587463
Link to your Codechef profile :https://www.codechef.com/users/asil2106122/edit
*/
import java.util.*;


public class Problem_2 {
 
    public static void main(String[] args)  {
 
        Scanner input = new Scanner(System.in);
        // take an integer C relative to the number of test cases.
        int C= input.nextInt();
        for (int i=1;i<=C;i++){
           // take an integer el relative to the energy level of a living being.
            int el= input.nextInt();
            //call isInsect method to cheak if the energy level is insect or not
            if(isInsect(el))
                System.out.println("Inseto!");
            else 
                System.out.println("Mais de 8000!");
        }  
    }
    // a method to calculate and return a true if it is an insect else a false if it is not.
    public static boolean isInsect(int el){
        if(el<=8000){
            return true;
        }    
         else 
            return false;
    }
}