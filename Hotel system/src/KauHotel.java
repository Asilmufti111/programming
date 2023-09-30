// CPCS 203
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class KauHotel {
    
    /*----------------------------------------------------------------------
   here 3 ArrayList are defined: 
    1- ArrayList to save all Guest objects and name it ‘guests’
    2- Array to save all Reservation objects and name it ‘reservations’ 
    3- ArrayList to save all HotelUnite objects and name it ‘unites’.
------------------------------------------------------------------------*/

    private static ArrayList<Guest> guests = new ArrayList<Guest>();
    private static ArrayList<Reservation> reservations = new ArrayList<Reservation>();
    private static ArrayList<HotelUnite> unites = new ArrayList<HotelUnite>();


    public static void main(String[] args) throws FileNotFoundException {

        int no, i, id,NumberOfRoom,NumberOfBathrooms,id1=0, id2=0, id3=0;
        double price,age;
        String Type,fname, lname;
        char gender;

        
        // OPEN FILES
        // Input File:
        File inputFile = new File("KauHotelInput.txt");
        if (!inputFile.exists()) {
            System.out.println("Input file, " + inputFile + ", does not exist.");
            System.exit(0);
        }
        // Output File:
        File outputFile = new File("KauHotelOuput.txt");

        // Make Scanner for input and Printwriter for output
        Scanner input = new Scanner(inputFile);
        PrintWriter output = new PrintWriter(outputFile);
        
        // reading data from the file
        String command = null;
        
        
        do {
            command = input.next();
            if (command.equalsIgnoreCase("Add_Room")) {
            
                //reading No of Rooms
                no = input.nextInt();
                i = 0;
                while (i < no) {
                    // Reading Room information
                    id = input.nextInt();
                    price = input.nextDouble();
                    Type = input.next();
                    unites.add(new Room(id, price, Type));
                    i++;
                    output.println("Room with the id ("+id+") was added successfully");
                }//while end
                

            } else if (command.equalsIgnoreCase("Add_Suite")) {
                no = input.nextInt();
                i = 0;
                while (i < no) {
                    // Reading Suite information

                    id = input.nextInt();
                    price = input.nextDouble();
                    NumberOfRoom = input.nextInt();
                    NumberOfBathrooms = input.nextInt();
                    unites.add(new Suite(id, price, NumberOfRoom, NumberOfBathrooms));
                    i++;
                    output.println("Suite with the id (" + id + ") was added successfully");

                }//while end
                output.println("--------------------------------------------------");

                }//end Add suite
            
//************************************Need To Be Done*********************************************************            
/// ***********************************For Student Add Guest Command******************************************
            
/*Makes a new guest, which is added to the system. The command will be followed by the following information:  

The first number (6) after the command in the file refers to the number of guests [ means system will accept ONLY SIX GUEST records details]. The Next Line will have the following information: 
	A String representing First Name of a guest
	A String representing Last Name of a guest
	A Character representing Gender of a guest
	An integer representing Id of a guest
	An integer representing Age of a guest*/
            
            else if (command.equalsIgnoreCase("Add_Guest")) {
                no = input.nextInt();
                i = 0;
                while (i < no) {
                    // Reading Suite information

                    fname = input.next();
                    lname = input.next();
                    gender = input.next().charAt(0);
                    id = input.nextInt();
                    age = input.nextInt();
                    guests.add(new Guest(fname, lname, gender, id, age));
                    i++;
                    output.println("Guest with the name (" + fname + " " + lname + ") was added successfully");

                }

                output.println("--------------------------------------------------");


                }//end Add Guest
//***********************end Student Work*************************************************************




//************************************Need To Be Done************************************************
/// ***********************************For Student Assign_Guest_HotelUnite Command*******************
/*Makes a new reservation which is added to the system. The command will be followed by the following information: 
The first number (4) after the command refers to the number of Reservation [ means system will accept ONLY four Reservation records details]. The Next will have the following information:
	An integer representing ID of a Reservation 
	HotelUnite is an object of HotelUnite class
	Guest is an object of Guest class.*/

            else if (command.equalsIgnoreCase("Assign_Guest_HotelUnite")) {

                no = input.nextInt();
                i = 0;
                while (i < no) {
                    // Reading Suite information

                    try {
                        id1 = input.nextInt();
                        id2 = input.nextInt();
                        id3 = input.nextInt();
                    } catch (InputMismatchException e) {
                    }
                     int guestsid = searchGuest(id2);
                    int unitesid = searchHotelUnite(id3);
                   
                      if (guestsid == -1) {
                        output.println("Assign command Unsuccessful\n"
                                + "Guest ID (" + id2 + ")  was not found ");
                                        output.println("--------------------------------------------------");
                      } if (unitesid == -1) {
                        output.println("Assign command Unsuccessful\n"
                                + "HotelUnite ID (" + id3 + ")  was not found  ");
                                        output.println("--------------------------------------------------");

                    }
                      else if (unites.get(unitesid).isAvailable() == false) {
                        output.println("Assign command Unsuccessful  HotelUnite ID (" + id3 + ") was not Available ");
                        output.println("--------------------------------------------------");

                    }
//غلطت في هذا الشرط كان فيه كم شيء ناقص الي هي هذه الثلاثة سطور.. 
//اول شيء كان لازم اضيف شرط انه موجود وثاني شيء لمن احجز لازم اخلي الاتاحة بفولس وثالث شيء السطر ما كتبته
                    if (unitesid != -1 && guestsid != -1&& unites.get(unitesid).isAvailable()==true) {
                        reservations.add(new Reservation(id1, unites.get(unitesid), guests.get(guestsid)));
                        unites.get(unitesid).setAvailable(false);
                        output.println("The Reservation with ID (" + id1 + ") is Assigned to a Guest with ID (" + id2 + ")  for Hotel Unite (" + id3 + ")");
                        output.println("--------------------------------------------------");

                    }
                    i++;

                }

                 
                 
                }//end Assign_Guest_HotelUnite Command 
                
                
  //***********************end Student Work*************************************************************

            
 
             
 //*********************Need To Be Done******************************************
/// ******************** Print_ Vacant _Room Command*******************
/*This command printout in the output file The Rooms (not Suit) ID That are Vacant 
Note: 
•You need to check the Availability of the Rooms using isAvailable() method in the HotelUnite class 
•Printout The Available Rooms in the output file (KauHotelOutput.txt)as in the output sample  
*/
            else if (command.equalsIgnoreCase("Print_Vacant_Room")) {
                output.println("Vacant Rooms in the Hotel are : ");

                for (int j = 0; j < unites.size(); j++) {
                    if (unites.get(j) instanceof Room && unites.get(j).isAvailable()) {
                        output.println(unites.get(j).getId() + " Room is vacant");
                    }
                }

  
            }// end Print_Vacant_Room
//***********************end Student Work*****************************************        

           
            
        } while (!command.equalsIgnoreCase("Quit"));//while
        output.println("\n\nThank you for using KAU Hotel system");
        

        
        output.flush();
        input.close();
        output.close();
    }//main

    public static int searchGuest(int id) {
        int index = -1;
        for (int i = 0; i < guests.size(); i++) {
            if (guests.get(i).getID()== id) {
                index= i;
            }
        }
        return index;
    }// search method end

    public static int searchHotelUnite( int ID) {
        int index = -1;
        for (int i = 0; i < unites.size(); i++) {

            if (unites.get(i).getId()== ID) {
                index= i;
            }
        }
        
        
        return index;
    }//search method end

}//class

