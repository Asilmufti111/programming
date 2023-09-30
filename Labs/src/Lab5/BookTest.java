
import java.util.Scanner;

public class BookTest {

    public static void main(String[] args) {
        System.out.println("the total number of books: " + Book.getCount());

        Book b1 = new Book("java", "Ali", "Ahmed", 2008);

        Scanner input = new Scanner(System.in);
        System.out.println("#####################################");
        System.out.println("Enter book title: ");
        String title = input.next();
        System.out.println("Enter first and last name of auther: ");
        String first_name = input.next();
        String last_name = input.next();
        System.out.println("Enter year:");
        int year = input.nextInt();
        Book b2 = new Book(title, first_name, last_name, year);
        
        Book b3 = new Book("java2", new Person("Mohammed", "Ali"), 2018);
        
        System.out.println("##########books information##########");
        System.out.println(b1.toString());
        System.out.println(b2.toString());
        System.out.println(b3.toString());
        System.out.println("#####################################");
        
        System.out.println("the total number of books: " + Book.getCount());

    }

}
