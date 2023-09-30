import java.util.Scanner;

public class Lab13_5 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of values: ");
            int[] values = new int[input.nextInt()];

            System.out.print("Enter the values: ");
            for (int i = 0; i < values.length; i++)
                    values[i] = input.nextInt();
            
            if (isConsecutiveFour(values))
                 System.out.println("The list has consecutive fours" );
            else
                 System.out.println("The list has no consecutive fours" );

                
    }

    public static boolean isConsecutiveFour(int[] values) {
            int count = 1; 

            for (int i = 0; i < values.length - 1; i++) {
                    if (values[i] == values[i + 1]) 
                        count++;
                     else 
                        count = 1;	
            
                    if (count >= 4) 
                        return true;

            }      
            return false;
    }
}


