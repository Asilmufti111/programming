package programming2;


/* 
Course Name: Programming II
Assignment Number: 1
 */
import java.io.*;
import java.util.Scanner;

public class AppWinnerSystem {

    public static void main(String[] args) throws FileNotFoundException {

        File input_file = new File("input1.txt");//create a file object to read from it

        if (!input_file.exists()) { //check that the file is exist
            System.out.println("The file does not exist");//display that the file does not exist
            System.exit(0);//exit from the program
        }
        
        Scanner input = new Scanner(input_file);//craete a scanner object to read by it from input file

        File output_file = new File("print.txt");//create a file object to write to it

        PrintWriter output = new PrintWriter(output_file);//craete a PrintWriter object to write by it on the output file
        output.println("\n\n***** Welcome to Best App Winner System *****\n ");//print on the output file

        final int UNIVERSITIES = input.nextInt();//reading the number of universities from the file
        final int DAYS_AND_DATES = input.nextInt();//reading the number of days and dates
        final int KAU_STUDENTS = input.nextInt();//reading number of students participating in the contest from King AbdulAziz University.
        final int KSU_STUDENTS = input.nextInt();//reading the number of students participating in the contest from King Saud University
        final int KKU_STUDENTS = input.nextInt();//reading  the number of students participating in the contest from King Khalid University. 
        final int KFU_STUDENTS = input.nextInt();//reading the number of students participating in the contest from King Fahad University.
        final int CONTEST_CRITERIA = input.nextInt();//reading the number of contest criteria.

        String[] universities_name = new String[UNIVERSITIES];// String array for the Universities name
        String[] days = new String[DAYS_AND_DATES];// String array for the Days of the Contest 
        String[] dates = new String[DAYS_AND_DATES];// String array for the Dates of the Contest 

        // String Two-Dimensional Rigid array to store students’ names who participated in the contest from each university.
        String[][] students = new String[UNIVERSITIES][];
        //determin the number of column(the students in each university)
        students[0] = new String[KAU_STUDENTS];
        students[1] = new String[KSU_STUDENTS];
        students[2] = new String[KKU_STUDENTS];
        students[3] = new String[KFU_STUDENTS];

        String[] criteria = new String[CONTEST_CRITERIA];// String array for the Contest Criteria

        int[][][] points = new int[UNIVERSITIES][][];// Three-Dimensional Array for the score
        //determine the number of rows(students from each university) and columns(number of the Contest Criteria)
        for (int i = 0; i < UNIVERSITIES; i++) {
            points[i] = new int[students[i].length][CONTEST_CRITERIA];
        }
        
        String command = " "; //craete a command variable to read the command from the input file
        while (!command.equals("Quit")) {//check that the command not equals to Quit --> if false then exit the loop
            command = input.next();// read the command from the file 
            if (command.equals("addUniversity")) {//check the contents of the command
                read_universities(universities_name, input);// call the method as a statment because it is a void method
            } else if (command.equals("addDays")) {//check the contents of the command
                read_days(days, input);// call the method to read the days from the input file
            } else if (command.equals("addDates")) {//check the contents of the command
                read_dates(dates, input);// call the method to read the dates
            } else if (command.equals("addStudentsName")) {//check the contents of the command
                read_students(students, input);// call the method to read the students name
            } else if (command.equals("addAwardCriteria")) {//check the contents of the command
                read_criteria(criteria, input);// call the method to raad the criteria
            } else if (command.equals("addScore")) {//check the contents of the command
                read_points(points, input);// call the method read the points scored
            } else if (command.equals("printcontestDetails")) {//check the contents of the command
                printContestDetails(output, universities_name, days, dates);// call the method to print Contest Details
            } else if (command.equals("printcontestdetailResults")) {//check the contents of the command
                printContestDetailResults(output, universities_name, students, criteria, points);// call the method to print Contest Detail Results
            } else if (command.equals("printwinnerAwardByEachCriteria")) {//check the contents of the command
                printWinnerAwardByEachCriteria(output, universities_name, students, criteria, points);// call the method to print Winner Award By Each Criteria
            }
        }
        
        input.close();//close the scanner object 
        output.println("\n	Thank you for using Best App Winner System, Good Bye!");//print the last sentence in the output file
        output.close();//close the printwriter object to make sure that it save what we have writen
    }

//-------------------------------------------------------------------------------------------
    
    //method that reads names of universities from the input.txt file
    public static void read_universities(String[] universities, Scanner input) {
        for (int i = 0; i < universities.length; i++) {// for loop to store universities name in an array
            universities[i] = textSplit(input.next());//read the university name and split it by textSplit method then store it in universities_name array
        }
    }

//-------------------------------------------------------------------------------------------
    
    //method that reads days of contests from the input.txt file
    public static void read_days(String[] day, Scanner input) {
        for (int i = 0; i < day.length; i++) {// for loop to store the days in an array
            day[i] = input.next();//read the day fron the input file and store it in days array
        }
    }

//-------------------------------------------------------------------------------------------
    
    //method that reads dates of contests from the input.txt file
    public static void read_dates(String[] date, Scanner input) {
        for (int i = 0; i < date.length; i++) {// for loop to store the dates in an array
            date[i] = input.next().replace("_", "/");//read the dates and replace all "_" to "/"

        }
    }

//-------------------------------------------------------------------------------------------
    
    //method that reads students name from the input.txt file
    public static void read_students(String[][] students, Scanner input) {
        // for loops to store students name
        for (int row = 0; row < students.length; row++) {//the row is the universities 
            for (int column = 0; column < students[row].length; column++) {// the column is the name of students from each university
                students[row][column] = textSplit(input.next());//read the student name and split it by textSplit method then store it in students array
            }

        }
    }

//-------------------------------------------------------------------------------------------
    
    //method that reads the criteria of contests from the input.txt file
    public static void read_criteria(String[] criteria, Scanner input) {
        for (int i = 0; i < criteria.length; i++) {// for loop to store the criteria in criteria array
            criteria[i] = textSplit(input.next());// read the criteria and split it by the textSplit method then store it
        }

    }

//-------------------------------------------------------------------------------------------
    
    //method that reads the points scored by each student in different category from each university 
    public static void read_points(int[][][] points, Scanner input) {
        // for loop to store the points in points array
        for (int i = 0; i < points.length; i++) {//loop for the university
            for (int j = 0; j < points[i].length; j++) {//loop for the student from each university
                for (int k = 0; k < points[i][j].length; k++) {//loop for the score of each student
                    points[i][j][k] = input.nextInt();//read the points from the input file then store it
                }
            }
        }
    }

//-------------------------------------------------------------------------------------------
    
    // Method to Print Contest Details on the print file
    public static void printContestDetails(PrintWriter output, String[] universities_name, String[] days, String[] dates) {
        output.println("------------  Contest App details are as follows ------");
        output.printf("%-30s%-30s%-30s", "University Name", "Contest Day", "Contest Date");
        output.println("\n------------------------------------------------------------------------------");
        for (int i = 0; i < 4; i++) {//4 : is the number of universities, days and dates
            output.printf(" %-30s%-30s%-30s\n", universities_name[i], days[i], dates[i]);
        }

    }

//-------------------------------------------------------------------------------------------
    
    // Method to Print Contest Detail Resultson the print file
    public static void printContestDetailResults(PrintWriter output, String[] universities_name, String[][] students, String[] criteria, int[][][] points) {
        for (int i = 0; i < universities_name.length; i++) {//for loop to print the universities name
            output.println("\n---Contest Results of  " + universities_name[i] + " is as Follows ---");
            for (int j = 0; j < students[i].length; j++) {// for loop to print the students name
                output.println("\n---Student Name   " + students[i][j] + " points  are as Follows ---");
                for (int k = 0; k < criteria.length; k++) {// for loop to print the criteria
                    output.println(" " + criteria[k] + " : " + points[i][j][k]);
                }
            }
        }

    }

//-------------------------------------------------------------------------------------------
    
    // Method to print winners from each university based on contest categories.
    public static void printWinnerAwardByEachCriteria(PrintWriter output, String[] universities_name, String[][] students, String[] criteria, int[][][] points) {
        for (int i = 0; i < criteria.length; i++) {// for loop for the contest criteria
            for (int j = 0; j < universities_name.length; j++) {// for loop to print the universities name
                output.println("\n--- Results of  " + universities_name[j] + " is as Follows ---");
                String winner_name = "";//winner name is empty by default
                int winner_score = 0;// winner score is zero by default
                for (int k = 0; k < students[j].length; k++) {// fot loop for students name from each university
                    if (points[j][k][i] > winner_score) {//compare the score
                        winner_score = points[j][k][i];// make the current score is the winner score
                        winner_name = students[j][k];//make the student name that have this score as winner  

                    }

                }
                //display the name of the winner student in each criteria
                output.println(" Contest Winner name in Category:   " + criteria[i] + " : \n " + winner_name);

            }

        }
    }

//-------------------------------------------------------------------------------------------
    
    // method to return a text by removing "_" char from the given text
    public static String textSplit(String text) {
        return text.replace("_", " ");// replace all "_" to white space 
    }

}
