/* Course : CPCS 202
Problem number : 3
Assignment number : 4
Link to your beecrowd/URI profile :https://www.beecrowd.com.br/judge/en/profile/587463
Link to your Codechef profile :https://www.codechef.com/users/asil2106122/edit
*/
import java.util.*;

public class Problem_3 {
 
    public static void main(String[] args)  {
        Scanner input = new Scanner(System.in);
        // take the number of testcasesfrom the user 
        int T= input.nextInt();
        for (int i=0;i<T;i++){
            // take a seven integers Amin,Bmin,Cmin,Tmin,A,B,C
            int minA= input.nextInt();
            int minB= input.nextInt();
            int minC= input.nextInt();
            int t= input.nextInt();
            int a= input.nextInt();
            int b= input.nextInt();
            int c= input.nextInt();
        // call isPass method and print if Chef passes the semester or not.
        System.out.println( isPass( minA,  minB,  minC, t, a, b, c));
        }
    }
    // a method to calculate and return a “NO” or a “YES” based on the input parameters.
     public static String isPass(int minA, int minB, int minC, int t, int a, int b, int c) {
         if(a+b+c>=t && a>=minA && b>=minB && c>=minC)
             return "YES";
         else 
             return "No";
    }
}
