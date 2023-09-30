
public class LAB7_Q2 {

    public static void main(String[] args) {
    int num=1,sum=0;
while (num<=10000){
    for (int i =0; i<num; i++){
         if (num%i==0)
         sum+=i;

    } 
if (sum==num)
System.out.println(num) ;
   }
    }

}
