/* Course : CPCS 202
Problem number : 4
Assignment number : 4
Link to your beecrowd/URI profile :https://www.beecrowd.com.br/judge/en/profile/587463
Link to your Codechef profile :https://www.codechef.com/users/asil2106122/edit
*/
import java.util.Scanner;

public class Problem_4 {
    public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
          // take the number of test cases
          int T= input.nextInt();
          
          for (int i=0;i<T;i++){
             // take the value of the salary for every day worked
             int X= input.nextInt();
             // take the value of the award for every day of that streak as a bonus
             int Y= input.nextInt();
             // a binary string , where '0'  did not work and '1'  the work day
             String st =  input.next();
             // call workingDays method and longestStreak method to calculate and print the total salary
             System.out.println((X*workingDays(st))+ (Y*longestStreak(st)));
            }
	}
    // a method to count and return the number of days the person has worked in 30 days.
    public static int workingDays(String st) {
        int workingDays=0;
        for(int i =0; i< st.length(); i++){
            if (st.charAt(i)=='1')
                workingDays++;
            }
            return workingDays;
    }
    // a method to count and return the length of the longest streak in 30 days.
    public static int longestStreak(String st){
         int longestStreak=1;
         int streak=1;
         for(int i =1; i< st.length(); i++){
            if (st.charAt(i)=='1' && st.charAt(i-1)=='1')
                 streak++;
            else
                 streak=1;
     
            if (streak>longestStreak)
                 longestStreak=streak;
         }
          return longestStreak;
    }
}
