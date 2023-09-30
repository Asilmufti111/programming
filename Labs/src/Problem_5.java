/* Course : CPCS 202
Problem number : 5 (1045)
Assignment number : 2
Link to your URI profile : https://www.urionlinejudge.com.br/judge/en/profile/587463
*/

import java.util.Scanner;
public class Problem_5 {
    
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        double A = input.nextDouble();
        double B = input.nextDouble();
        double C = input.nextDouble();
        double temp;
        
        if (B>A){
        temp= A;
        A=B;
        B=temp;
        }              
        if (C>A){
        temp= A;
        A=C;
        C=temp;
        }
         if (C>B){
        temp= B;
        B=C;
        C=temp;
        }
       
        
        if (A>=B+C)
        System.out.println("NAO FORMA TRIANGULO");

        else if ((Math.pow(A,2) == (Math.pow(B,2)+ Math.pow(C,2))))
        System.out.println("TRIANGULO RETANGULO");

        else if (Math.pow(A,2)> Math.pow(B,2)+ Math.pow(C,2))
        System.out.println("TRIANGULO OBTUSANGULO");

        else if (Math.pow(A,2)< Math.pow(B,2)+ Math.pow(C,2))
        System.out.println("TRIANGULO ACUTANGULO");

        if (A==B && B==C)
        System.out.println("TRIANGULO EQUILATERO");  

        else if (A==B || B==C || A==C)
        System.out.println("TRIANGULO ISOSCELES");
 


    }
 
}

    

