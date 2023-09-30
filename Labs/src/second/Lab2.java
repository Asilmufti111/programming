
import java.util.Scanner;

public class Lab2 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Course ID Generator:");
        System.out.println("----------------------------------");
        System.out.println("Please Enter Course Information");
        StringBuilder courseID = new StringBuilder();
        String courseCode, courseNumber;
        do {
            System.out.println("Course Code (only capital letters with a length between 2 and 4):");
            courseCode = input.next();
            if (courseCode.matches("[A-Z]{2,4}")) {
                courseID.append(courseCode);
                break;
            } else if ((courseCode.length() > 1 && courseCode.length() < 5) == false) {
                System.out.println("Course Code length was not between 2 and 4 , Please try again");
            } else {
                System.out.println("Course Code must only have capital letters , Please try again");
            }

        } while (true);

        while (true) {
            System.out.println("Course Number (consist only of 3 digits):");
            courseNumber = input.next();

            if (courseNumber.length() == 3) {
                courseID.append(courseNumber);
                break;
            } else {
                System.out.println("Course Number length was not 3 , Please try again");
            }
        }

        System.out.println("Year:");
        int year = input.nextInt();
        courseID.append("-" + year);

        while (true) {

            System.out.println("Semester (Fall=01, Sprint=02, Summer=03):");
            int semester = input.nextInt();
            if (semester != 1 && semester != 2 && semester != 3) {
                System.out.println("Please enter correct semester code, try again");
            } else {
                courseID.append("0" + semester + "-");
                break;
            }
        }

        System.out.println("Course Reference Number:");
        int secionReferenceNumber = input.nextInt();
        courseID.append(secionReferenceNumber);

        System.out.println("----------------------------------");

        System.out.println("Generated Course ID:" + courseID);

    }

}
