/* Course : CPCS 202
Problem number : 6 (1103)
Assignment number : 2
Link to your URI profile : https://www.urionlinejudge.com.br/judge/en/profile/587463
*/
import java.util.Scanner;
import java.lang.Math;

public class Problem_6 {
     public static void main(String[] args) {

      Scanner input = new Scanner(System.in);
      int h1, m1, h2, m2;
      int sleep,min,hour;

      while (true) {

        // code to read four numbers as h1, m1, h2
       // and m2 here
       h1= input.nextInt();
       m1= input.nextInt();
       h2= input.nextInt();
       m2= input.nextInt();

       if (h1==0 && m1==0 && h2==0 && m2==0) break;

      // code to do the calculation and print the output
       if (m2<m1){
       m2= m2+60;
       h2= h2-1;
       }
       if(h1>h2)
       h2= h2+24;
     
       min= m2-m1;
       hour= (h2-h1)*60;
       sleep= min+hour;
       
       System.out.println(sleep);
       
       
       }
    }
}

    
    

