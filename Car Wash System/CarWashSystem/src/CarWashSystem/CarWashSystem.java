

//course number: CPCS204
//date: 9 NOV 2022

package CarWashSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class CarWashSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // open the input file and create the output file
        File InputFile = new File("input.txt");
        //create a Scanner object to read from the input file
        Scanner input = new Scanner(InputFile);

        File outputFile = new File("output.txt");
        PrintWriter output = new PrintWriter(outputFile);
        output.println("		 Car Wash System\n" + "	---------------------------------------------------------\n" + "");

        String command;

        // read the first command
        //----------------------------------------------
        command = input.next();
        QueueOfCustomerLL costemers = new QueueOfCustomerLL();
        QueueOfService service1 = new QueueOfService(20);
        QueueOfService service2 = new QueueOfService(20);
        StackOfBN bills = new StackOfBN(40);
        int bill = 1;
       int  washSize = 0;
               int polishSize = 0;

        // Loop through the input file
        while (!command.equals("Report")) {
            // case 1: Register        
            if (command.equals("Register")) {
                String fname = input.next();
                String lname = input.next();
                String serv = input.next();

                costemers.enqueue(new Customer(fname, lname, serv, bill++, null));
                output.println(fname + " " + lname + "		  REGISTER in finalLab2023_1_final.QueueOfCustomerLL (Main Queue)  	 Requested service  (" + serv + ")\n");
            } // case 2: Serve
            else if (command.equals("Serve")) {
                if (!costemers.isEmpty()) {
                    if (costemers.peek().getserviceName().equals("Wash")) {
                        if (service1.isFull()) {
                            output.println("the service queue in fill");
                        } else {
                            service1.enqueue(costemers.peek());
                        }
                    } else {
                        if (service2.isFull()) {
                            output.println("the service queue in fill");
                        } else {
                            service2.enqueue(costemers.peek());
                        }
                    }
                }
                output.println(costemers.peek().getFirstName() + " " + costemers.peek().getLastName()+ "		 wants " + costemers.peek().getserviceName() + " car service with bill number :" + costemers.peek().getBN() + "\n");
                costemers.dequeue();
            } //case3: Finish
            else if (command.equals("Finish")) {
            ///wrongggg////////////////////////////////    //   while (!costemers.isEmpty()) {
             //wrongggg////////////////////////////////////    //     bills.push(costemers.dequeue().getBN());
              //wrongggg//////////////////////////////////////////    //}
                washSize = service1.size();
                polishSize = service2.size();

                while (!service1.isEmpty()) {
                    bills.push(service1.dequeue().getBN());
                }
                while (!service2.isEmpty()) {
                    bills.push(service2.dequeue().getBN());
                }

            }

            // read the next command
            command = input.next();
        }// End loop

        // Print the total requsts of each service type & total customer served with bill numbers
        output.println("Total Polish Requests were: " + polishSize  + "\n"
                + "\n"
                + "Total Wash Requests were: " + washSize  + "\n"
                + "");
        output.println("The total number of customers served today: "+bills.size()+" with bill numbers: ");
       /////////wrongggg////////////////////////////////// bills.PrintStack();
       
        while (!bills.isEmpty()) {
           output.print(bills.pop() + ", ");
        }

        // closing the files
        output.flush();
        output.close();
    }

}
