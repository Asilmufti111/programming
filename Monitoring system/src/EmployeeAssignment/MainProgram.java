
//Assigment title: prodects assignment monitoring system
//Assigment date thursday sep 29, 20022

package EmployeeAssignment;

import java.io.*;
import java.util.*;

public class MainProgram {

    public static void main(String[] args) throws FileNotFoundException {
        File inputInfo = new File("intialInformation.txt");//create a file object to read from intialInformation file

        if (!inputInfo.exists()) { //check that the file is exist
            System.out.println("The intial Information file does not exist");//display that the file does not exist
            System.exit(0);//exit from the program
        }
        
        Scanner input1 = new Scanner(inputInfo);//craete a scanner object to read by it from intialInformation file
        File inputCommands = new File("Commands.txt");//create a file object to read from Commands file

        if (!inputCommands.exists()) { //check that the file is exist
            System.out.println("The Commands file does not exist");//display that the file does not exist
            System.exit(0);//exit from the program
        }
        
        Scanner input2 = new Scanner(inputCommands);//craete a scanner object to read by it from commands file
        File result = new File("Output.txt");//create a file object to write the output in it
        PrintWriter output = new PrintWriter(result); //craete a PrintWriter object to write by it in  the output file
        output.println("\t\t\t\t\t\tWelcome to Shopping Center Employee Management System");//print statment 
        output.println("\t\t\t\t\t\t---------------------------------------------------------------------------");//display on output file
       
        int employeesNum = input1.nextInt();//take the number of employees from the intialinformation file
        int centersNum = input1.nextInt();//take the number of centers from the intialinformation file
        int productsNum = input1.nextInt();//take the number of prodects from the intialinformation file
        
        String[] centersName = new String[centersNum];//array for centers name
        //fill the array with the name of the centers from the input file 
        for (int i = 0; i < centersName.length; ++i) {
            centersName[i] = input1.next();
        }

        String[] prodectsName = new String[productsNum];// array for prodects name
        //fill the array with the name of the prodects from the input file 
        for (int i = 0; i < prodectsName.length; ++i) {
            prodectsName[i] = input1.next();
        }
        
        String[][] employeeInfo = new String[employeesNum][3];//2d array for employees ids and names(first and last)
        //fill the array with employees ids and names
        for (int i = 0; i < employeesNum; ++i) {
            for (int j = 0; j < 3; ++j) {
                employeeInfo[i][j] = input1.next();
            }
        }
        
        //array for the number of centers 
        int[] centersNumber = new int[centersNum];
        //fill the array with the number of centers from the input file 
        for (int i = 0; i < centersNumber.length; ++i) {
            centersNumber[i] = input1.nextInt();
            input1.nextLine();//ignore the name of the center becouse it alrady took in the centersName array
        }
        
        //array of center object
        Center[] centers = new Center[centersNum];
        String command = ""; //craete a command variable to read the command from command file
        int first = 0, first1 = 0, first2 = 0;//i used it to format the lines 
       
        while (!command.equals("QUIT")) {//check that the command not equals to Quit --> if false then exit the loop
            command = input2.next();// read the command from input file 

            if (command.equals("STARTUP")) {//check the contents of the command
                int k = 0;//variable to move in the rows of employeeInfo array
                for (int i = 0; i < centers.length; ++i) {
                    centers[i] = new Center();//create an object in each index in the array 
                    for (int j = 0; j < productsNum; ++j) {
                        //add a new node in the list
                        centers[i].add(employeeInfo[k][0], employeeInfo[k][1], employeeInfo[k][2], centersNumber[i], 0, "", prodectsName[j], centersName[i]);
                        k++;
                    }
                }
            }
            else if (command.equals("DISPLAY_ALL_CENTERS")) {//check the contents of the command
                output.println("\t\t\t\t\t\t\t\tInformation of Employees in Each Center\n");

                for (int i = 0; i < centersNum; ++i) {
                    output.println("\t\t\t\tEmployees in  " + centersName[i] + " Center");
                    output.println("\tID\t\tName\t\t\tProduct ");
                    //help ptr to traverse in the list from the first node to the last one
                    Employee helpptr = centers[i].getHead();
                    for (int j = 0; j < productsNum; ++j) {
                        //print all employee information
                        output.println("\t" + helpptr.getId() + "\t\t" + helpptr.getfName() + " " + helpptr.getlName() + "\t\t" + helpptr.getProduct());
                        helpptr = helpptr.getNext();// move to the next node 
                    }
                    output.println("\t\t\t----------------------------------------------");
                }
            }
            else if (command.equals("DISPLAY_PRODUCTS_FOR_EMPLOYEE")) {//check the contents of the command

                String id = input2.next();// take the id from command file 
                boolean found = false;//to know if the id is exist or not 
                for (int i = 0; i < centersNum; ++i) {
                    //save the node of the id i want to display it's information
                    Employee helpptr = centers[i].search(id);
                    if (centers[i].search(id) != null) {//the id is exist 
                        found = true;//i find the id 
                        //print the information of the employee
                        output.println("\t\"Employee: " + helpptr.getfName() + " " + helpptr.getlName() + ", " + helpptr.getId() + ", is assigned to " + helpptr.getProduct() + ", in " + centersName[centerNameFromNum(centersNumber, helpptr.getCenterNum())] + " center  \"	");
                        break;//just 1 employee i want to display his/her information
                    }
                }
                if (found == false) {//if the id does not exist 
                    output.println("\tNo employee of this number is found");
                }

            }
            else if (command.equals("NUM_OF_EMPLOYEES")) {//check the contents of the command
                if (first1 == 0) {//print this line just for the first time you applay this command
                    output.println("----------------------------------------------------------------------------\n");
                    first1++;
                }
                String center = input2.next();//take the name of the center from the command file 
                int employeeNum = 0;
                for (int i = 0; i < centers.length; ++i) {
                    if (centersName[i].equals(center)) {//finding the name of the center 
                        employeeNum = count(centers[i]);//call count method to return the number or the emloyees in a specific center 
                        break;
                    }
                }
                output.println("\t\t\tNumber of employess in " + center + " center: " + employeeNum);
            } 
            else if (command.equals("DISPLAY_BASED_ON_PRODUCT")) {//check the contents of the command
                if (first == 0) {//print this line just for the first time you applay this command
                    output.print("\n----------------------------------------------------------------------------");
                    first++;
                }

                String prodect = input2.next();
                output.println("\n\t\t\tEmployees for Product " + prodect);
                output.println("\tID\t\tName\t\t\tCenter ");

                for (int i = 0; i < centers.length; ++i) {
                    centers[i].printBaseOnProdect(prodect, output);
                }

            } 
            else if (command.equals("CHANGE_TO_NULL_PRODUCT")) {//check the contents of the command
                if (first2 == 0) {//print this line just for the first time you applay this command
                    output.println("==========================================================================\n");
                    first2++;
                }
                String id = input2.next();
                //help pointer to store the node of the id i want to change
                Employee helpptr = centers[0].getHead();//initialize the pointer with the head point 
                for (int i = 0; i < centers.length; ++i) {
                    if (centers[i].search(id) != null) {
                        helpptr = centers[i].search(id);//storing the node of the id i want to change
                        helpptr.setProduct("Null");//change the prodect to null 
                    }
                }
                output.println("\t\t\tChange Assigned Product to Null ");
                output.println("\tProducts for  " + helpptr.getfName() + " " + helpptr.getlName() + " : " + helpptr.getId() + " has been changed to null\n");

            }
            else if (command.equals("SWAP_BETWEEN_EMPLOYEES")) {
                output.println("==========================================================================");
                output.println("\t\t\tSwap Centers Between Two Employees ");
                String id1 = input2.next();
                String id2 = input2.next();
                swap2employees(id1, id2, centers, centersName, centersNumber, output);
                output.println("==========================================================================\n\n");
            }
        }
        
        //printing the end of the file 
        output.println("\n\n\n\n\t============================");
        output.println("\t\tBest Wishes ");
        output.println("\t============================");
        output.flush();//print everything now 
        output.close();//close the output file 
    }

    //method to find the name of the center from it's number 
    public static int centerNameFromNum(int[] centerNumber, int num) {
        for (int i = 0; i < centerNumber.length; ++i) {
            if (centerNumber[i] == num) {
                return i;
            }
        }
        return -1;
    }

    //method to count th enumber of the employees in specific center 
    public static int count(Center center) {
        int i = 0;//counting the number of nodes(employees)
        //help pointer to treverse the list 
        Employee helpptr = center.getHead();
        while (helpptr != null) {//till the end 
            helpptr = helpptr.getNext();
            i++;//increment the counter 
        }
        return i;
    }

    private static void swap2employees(String id1, String id2, Center[] centers, String[] centersName, int[] centersNumber, PrintWriter output) {
        String tempId = "", tempFname = "", tempLname = "";//variable to help me in swaping the employee information
        Employee helpptr1 = centers[0].getHead(), helpptr2 = centers[0].getHead();
        for (int i = 0; i < centers.length; ++i) {
            if (centers[i].search(id2) != null) {
                helpptr1 = centers[i].search(id2);//store the node of the id i want to swap 
                tempId = helpptr1.getId();
                tempFname = helpptr1.getfName();
                tempLname = helpptr1.getlName();

            } else if (centers[i].search(id1) != null) {
                helpptr2 = centers[i].search(id1);// store the node of the second id i want to swap 
                //swaping between 2 employee id , first name and last name 
                helpptr1.setId(helpptr2.getId());
                helpptr1.setfName(helpptr2.getfName());
                helpptr1.setlName(helpptr2.getlName());
                helpptr2.setId(tempId);
                helpptr2.setfName(tempFname);
                helpptr2.setlName(tempLname);
            }
        }
        output.println("\t" + helpptr1.getfName() + " " + helpptr1.getlName() + " in " + centersName[centerNameFromNum(centersNumber, helpptr2.getCenterNum())] + " center is SWAPED WITH  " + helpptr2.getfName() + " " + helpptr2.getlName() + " in " + centersName[centerNameFromNum(centersNumber, helpptr1.getCenterNum())] + " center \n");
    }
}
