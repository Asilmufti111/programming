/* 
Course Name: Programming II
Assignment Number: 3
 */
package HospitalSystem;

import java.io.*;
import java.util.*;

public class KAUHospitalSystem {

    public static void main(String[] args) throws FileNotFoundException {

        File inputFile = new File("input.txt");//create a file object to read from it

        if (!inputFile.exists()) { //check that the file is exist
            System.out.println("The input file does not exist");//display that the file does not exist
            System.exit(0);//exit from the program
        }

        Scanner input = new Scanner(inputFile);//craete a scanner object to read by it from input file

        File outputFile = new File("Output.txt");//create a file object to write in it
        PrintWriter output = new PrintWriter(outputFile); //craete a PrintWriter object to write by it in output file
        output.println("--------------- Welcome to KAU Hospital System ---------------");//print on the output file

        //create 3 arrays to store all the data used in the system and read the size of them from the input file 
        Room[] HRooms = new Room[input.nextInt()];
        Medicine[] HMedicines = new Medicine[input.nextInt()];;
        Person[] HPersons = new Person[input.nextInt()];// store all Doctors, Nurse and Patients in the hospital

        String command = ""; //craete a command variable to read the command from input file
        int HRoomsCounter = 0;//to count the objects in HRooms array 
        int HMedicinesCounter = 0;//to count the objects in HMedicines array 
        int HPersonsCounter = 0;//to count the objects in HPersons array 

        while (!command.equals("Quit")) {//check that the command not equals to Quit --> if false then exit the loop
            command = input.next();// read the command from input file 

            if (command.equals("Add_Room")) {//check the contents of the command
                output.println("Command Add_Room: Add a new room record in the System");
                HRooms[HRoomsCounter] = getRoom(input);//invoke getRoom method to fill HRooms array
                output.println(HRooms[HRoomsCounter].toString());//print the room object in the output file
                HRoomsCounter++;// increase the counter of objects in HRooms array 
                printLine(output,1);// invoke printLine method to print a dash line in the output file 

            } else if (command.equals("Add_Medicine")) {//check the contents of the command
                output.println("Command Add_Medicine: Add a new Medicine record in the System");
                HMedicines[HMedicinesCounter] = getMedicineRecord(input);//invoke getMedicineRecord method to fill HMedicines array
                output.print(HMedicines[HMedicinesCounter].toString());//print the Medicines object in the output file
                HMedicinesCounter++;// increase the counter of objects in HMedicines array 
                printLine(output,1);// invoke printLine method to print a dash line in the output file 

            } else if (command.equals("Add_Doctor")) {//check the contents of the command
                output.println("Command Add_Doctor: Add a new doctor record in the System");
                HPersons[HPersonsCounter] = getDoctor(input);//invoke getDoctor method to fill the array
                output.print(HPersons[HPersonsCounter].toString());//print the doctor object
                HPersonsCounter++;// increase the counter of objects in HPersons array 
                printLine(output,1);// invoke printLine method to print a dash line in the output file 

            } else if (command.equals("Add_Nurse")) {//check the contents of the command
                output.println("Command Add_Nurse: Add a new nurse record in the System");
                HPersons[HPersonsCounter] = getNurse(input);//invoke getNurse method to fill the array
                output.print(HPersons[HPersonsCounter].toString());//print the nurse object
                HPersonsCounter++;// increase the counter of objects in HPersons array 
                printLine(output,1);// invoke printLine method to print a dash line in the output file

            } else if (command.equals("Add_Patient")) {//check the contents of the command
                output.println("Command Add_Patient: \n" + "Add a new Patient record in the System");
                HPersons[HPersonsCounter] = getPatientRecord(input);//invoke getPatientRecord method to fill the array
                output.print(HPersons[HPersonsCounter].toString());//print the patient object
                HPersonsCounter++;// increase the counter of objects in HPersons array 
                printLine(output,2);// print dash line

            } else if (command.equals("Assign_Doctor_Patient")) {//check the contents of the command
                output.println("Command Assign_Doctor_Patient:");
                // read doctor id and patient Id from the input file 
                int doctorId = input.nextInt();
                int patientId = input.nextInt();
                //invoke isPersonExist method to check that both patient and doctor exist
                Doctor doctor = (Doctor) isPersonExist(HPersons, doctorId);
                Patient patient = (Patient) isPersonExist(HPersons, patientId);
                // if the doctor does not exist, print doctor not found 
                if (doctor == null) {
                    output.println("Doctor " + doctorId + " NOT FOUND ");
                    printLine(output,2);// print dash line 

                } // if the patient does not exist, print patient not found 
                else if (patient == null) {
                    output.println("Patient " + patientId + " NOT FOUND ");
                    printLine(output,2);//print dash line 

                } else {// both patient and doctor exist
                    patient.setDoctor(doctor);//Assign the doctor to the patient 
                    output.println("Successfully Processed by the System:\n"
                            + "Following are the details:\n"
                            + "\t\tPatient: " + patient.getName() + "\n"
                            + "\t\tAssigned to Doctor: " + doctor.getName());
                    printLine(output,2);//print dash line 
                }

            } else if (command.equals("Assign_Room_Patient")) {//check the contents of the command
                output.println("Command Assign_Room_Patient:");
                // read room number and patient Id from the input file 
                int roomNo = input.nextInt();
                int patientId = input.nextInt();
                //invoke isPersonExist method to check that the patient exist
                Patient patient = (Patient) isPersonExist(HPersons, patientId);
                //invoke isRoomExist method to check that the room exist
                Room room = isRoomExist(HRooms, roomNo);

                // if the patient does not exist, print patient not found 
                if (patient == null) {
                    output.println("Patient " + patientId + " NOT FOUND ");
                    printLine(output,3);

                } // if the room does not exist, print room not found 
                else if (room == null) {
                    output.println("Room " + roomNo + " NOT FOUND ");
                    printLine(output,3);

                } else {// both patient and room exist
                    patient.setRoom(room);//Assign the room to the patient 
                    output.println("Successfully Processed by the System:\n"
                            + "Following are the details:\n"
                            + "\tPatient: " + patient.getName() + "\n"
                            + "\tAssigned to Room:" + room.toString());
                    printLine(output,3);
                }

            } else if (command.equals("Assign_Medicine_Patient")) {//check the contents of the command
                output.println("Command Assign_Medicine_Patient:");
                int patientId = input.nextInt(); // read the patient Id
                Patient patient = (Patient) isPersonExist(HPersons, patientId);//call the method and get the object if exist 
                // if does not exist ,print not found
                if (patient == null) {
                    output.println("Patient " + patientId + " NOT FOUND ");
                    printLine(output,4);

                } else {//patient is exist
                    int totalMedicine = input.nextInt();// read total medicine
                    //check if the total medicine is correct or not
                    if (totalMedicine != patient.getTotalMedicine()) {
                        output.println("Information mismatch: Patient " + patientId + "must have " + patient.getTotalMedicine() + " medicine not " + totalMedicine);
                        printLine(output,4);
                    } else {//total medicine is correct
                        boolean allExist = true;//all medicine exist flag
                        //for loop to check that all medicines exist
                        for (int i = 0; i < patient.getTotalMedicine(); i++) {
                            int medicineCode = input.nextInt();//read the medicine Code
                            Medicine medicine = isMedicineExist(HMedicines, medicineCode);//invoke isMedicineExist method and the object if exist
                            if (medicine == null) {//medicine does not exist
                                allExist = false;//change the flag
                                output.println("Medicines " + medicineCode + " NOT FOUND ");
                                printLine(output,4);//print dash line 

                            } else {//if the medicine is exist
                                patient.setMedicine(medicine, i);// assign the medicine to the patient

                            }
                        }
                        if (allExist == true) {//if all medicines exist
                            output.println("Successfully Processed by the System:\n"
                                    + "Following are the details:\n"
                                    + "\tPatient: " + patient.getName());
                            //for loop to print all medicines
                            for (int i = 0; i < patient.getTotalMedicine(); i++) {
                                output.println("\tMedicine Prescribed: " + patient.getMedicine(i).getName());

                            }
                            printLine(output,4);
                        }

                    }

                }

            } else if (command.equals("Print_Bill")) {//check the contents of the command
                output.println("\nCommand: Print_Bill\n\n\n\n"
                        + "--------------- Welcome to KAU Hospital System ---------------\n\n"
                        + "--------- Current Date :  " + new Date() + "--------\n\n"//print the current day 
                        + "==================================================================");

                Arrays.sort(HPersons);//sort HPersons array by person id
                //for loop to print all patients details and bill 
                for (int i = 0; i < HPersons.length; i++) {
                    if (HPersons[i] instanceof Patient) {//select only patients from HPersons array
                        output.println(((Patient) HPersons[i]).printPatientBasicInfo()
                                + "\n\t\t==== Total Charges :" + ((Patient) HPersons[i]).calTotalBill() + " SR ====");
                        printLine(output,1);//print dash line
                    }

                }
            }
        }

        output.print("Thank you for using KAU Hospital System, Good Bye!");
        input.close();//close the scanner that read from input file
        output.close();// close the printwritter that print in output file
    }

//-------------------------------------------------------------------------------------------    
    //method to get the doctor object to fill the array  
    private static Doctor getDoctor(Scanner input) {
        // read the constructor of the doctor object from the input file 
        double consultationFees = Double.valueOf(input.next());// I read it as a String then convert it to double because when I read it by nextDouble shows error !!
        String staffid = input.next();
        String specialization = input.next();
        int id = input.nextInt();
        String name = input.next();
        String nationality = input.next();
        char gender = input.next().charAt(0);
        int phone = input.nextInt();
        //create a doctor object with it's constructor and return it 
        return new Doctor(consultationFees, staffid, specialization, id, name, nationality, gender, phone);
    }

//-------------------------------------------------------------------------------------------    
    //method to get the Nurse object to fill the array  
    private static Nurse getNurse(Scanner input) {
        //create a Nurse object by reading it's constructor (experience,staffid,specialization,id,name,nationality,gender,phone)from input file and return it 
        return new Nurse(input.nextInt(), input.next(), input.next(), input.nextInt(), input.next(), input.next(), input.next().charAt(0), input.nextInt());
    }

//-------------------------------------------------------------------------------------------    
    //method to get the Room object to fill the array  
    private static Room getRoom(Scanner input) {
        // read the constructor of the room object from the input file 
        int roomNo = input.nextInt();
        String floor = input.next();
        String block = input.next();
        double charges = Double.valueOf(input.next());// I read it as a String then convert it to double because when I read it by nextDouble shows error !!
        //create a room object with it's constructor and return it 
        return new Room(roomNo, floor, block, charges);
    }

//-------------------------------------------------------------------------------------------    
    //method to get the Medicine object to fill the array  
    private static Medicine getMedicineRecord(Scanner input) {
        //create a Medicine object by reading it's constructor (medicineCode,name,price)from input file and return it         
        return new Medicine(input.nextInt(), input.next(), Double.valueOf(input.next()));// I read medicineCode as a String then convert it to double because when I read it by nextDouble shows error !!
    }

//-------------------------------------------------------------------------------------------    
    //method to get the Patient object to fill the array  
    private static Patient getPatientRecord(Scanner input) {
        // read the constructor of the Patient object from the input file         
        String illness = input.next();
        String bloodGroup = input.next();
        int id = input.nextInt();
        String name = input.next();
        String nationality = input.next();
        char gender = input.next().charAt(0);
        int phone = input.nextInt();
        int totalMedicine = input.nextInt();
        //create a Patient object with it's constructor and return it         
        return new Patient(illness, bloodGroup, id, name, nationality, gender, phone, totalMedicine);
    }

//-------------------------------------------------------------------------------------------    
    //method to check the person object exist or not 
    private static Person isPersonExist(Person[] HPersons, int Id) {
        //for loop on the HPersons array
        for (int i = 0; i < HPersons.length; i++) {
            if (HPersons[i].getId() == Id) {//check the id
                return HPersons[i];//return the object when found 
            }
        }
        return null;// the object(patient or doctor)does not exist.
    }

//-------------------------------------------------------------------------------------------    
    //method to check the room object exist or not 
    private static Room isRoomExist(Room[] HRooms, int roomNo) {
        //for loop on the HRooms array
        for (int i = 0; i < HRooms.length; i++) {
            if (HRooms[i].getRoomNo() == roomNo) {//check the room number
                return HRooms[i];//return the object when found 
            }
        }
        return null;// the object(room)does not exist.
    }

//-------------------------------------------------------------------------------------------    
    //method to check the Medicine object exist or not 
    private static Medicine isMedicineExist(Medicine[] HMedicines, int medicineCode) {
        //for loop on the HMedicines array        
        for (int i = 0; i < HMedicines.length; i++) {
            if (HMedicines[i].getMedicineCode() == medicineCode) {//check the medicine Code
                return HMedicines[i];//return the object when found 
            }
        }
        return null;// the object(Medicine)does not exist.
    }

//-------------------------------------------------------------------------------------------    
    //method to print dash line 
    public static void printLine(PrintWriter output, int length) {
        if (length == 1) {
            output.println("----------------------------------------------------------------");
        } else if (length == 2) {
            output.println("-------------------------------------------------------------------------------");
        } else if (length == 3) {
            output.println("---------------------------------------------------------------------------------");
        } else if (length == 4) {
            output.println("-----------------------------------------------------------------------------");
        }

    }
}
