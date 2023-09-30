import java.util.Scanner;

public class Lab12_5 {

    public static void main(String[] args) {
	Scanner input = new Scanner(System.in);

        System.out.print("Enter list1: ");
        int[] list1 = new int[input.nextInt()];
	for (int i = 0; i < list1.length; i++){
		list1[i] = input.nextInt(); 	
        }
	System.out.print("Enter list2: ");
        int[] list2 = new int[input.nextInt()];
	for (int i = 0; i < list2[0]; i++){
            list2[i] = input.nextInt();
        }
	 boolean answer = false;
         if (list1.length == list2.length){
	      for (int i = 0; i < list1.length; i++) {
                  if (list1[i] == list2[i])
                      answer= true;
                  else 
                     answer= false; break;
         
              }
         }
         if (answer)
            System.out.println("Tow lists are strictly identical");
         else 
            System.out.println("Tow lists are not strictly identical");

    }
}

    

