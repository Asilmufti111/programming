/* 

Course Name: Programming II
Assignment Number: 2
 */
package CICS_Database;

import java.io.*;
import java.util.*;

public class CICS_Database {

    public static void main(String[] args) throws FileNotFoundException {

        File inputCICSData = new File("inputCICSData.txt");//create a file object to read from inputCICSData file

        if (!inputCICSData.exists()) { //check that the file is exist
            System.out.println("The input CICS Data file does not exist");//display that the file does not exist
            System.exit(0);//exit from the program
        }
        Scanner input1 = new Scanner(inputCICSData);//craete a scanner object to read by it from inputCICSData file

        File CICSDatabase = new File("CICSDatabase.txt");//create a file object to write in it
        PrintWriter output1 = new PrintWriter(CICSDatabase); //craete a PrintWriter object to write by it in  CICSDatabase file
        output1.println("--------------- Welcome to CICS  Database ---------------\n");//print on CICSDatabase file

        final int NUMBER_OF_CARS = input1.nextInt();//reading the number of cars from inputCICSData file
        final int NUMBER_OF_OWNERS = input1.nextInt();//reading the number of owners from inputCICSData file
        final int NUMBER_OF_INSURANCE_COVERAGES = input1.nextInt();//reading number of insurance coverage from inputCICSData file

        Car[] cars = new Car[NUMBER_OF_CARS];// create a cars array from Car class type
        Owner[] owners = new Owner[NUMBER_OF_OWNERS];;// create an owners array from Owner class type
        InsuranceCoverage[] insuranceCoverage = new InsuranceCoverage[NUMBER_OF_INSURANCE_COVERAGES];// create an insuranceCoverage array from InsuranceCoverage class type

        String command_inputCICSData = " "; //craete a command variable to read the command from inputCICSData file
        int carsCounter = 0;//to count the objects in cars array 
        int ownersCounter = 0;//to count the objects in owners array 
        int insuranceCoverageCounter = 0;//to count the objects in insuranceCoverage array 

        while (!command_inputCICSData.equals("Quit")) {//check that the command not equals to Quit --> if false then exit the loop
            command_inputCICSData = input1.next();// read the command from inputCICSData file 

            if (command_inputCICSData.equals("AddCar")) {//check the contents of the command
                //create a car object in cars array by reading the constructor (CarPlateNo, CarType, Brand, CarModel, CarColor, BuiltYear)from inputCICSData file 
                cars[carsCounter] = new Car(input1.next(), input1.next(), input1.next(), input1.next(), input1.next(), input1.nextInt());
                carsCounter++;// increase the counter of objects in cars array 

            } else if (command_inputCICSData.equals("AddOwner")) {//check the contents of the command
                //create an Owner object in owners array by reading the constructor ( nationalID, First_name, Last_name, dob)from inputCICSData file 
                owners[ownersCounter] = new Owner(input1.next(), input1.next(), input1.next(), new Date(input1.nextInt(), input1.nextInt(), input1.nextInt()));
                ownersCounter++;// increase the counter of objects in owners array 

            } else if (command_inputCICSData.equals("AddInsuranceCoverage")) {//check the contents of the command
                //create an InsuranceCoverage object in insuranceCoverage array by reading the constructor ( insuranceCoverageCode,  description,  amount)from inputCICSData file 
                insuranceCoverage[insuranceCoverageCounter] = new InsuranceCoverage(input1.nextInt(), input1.next(), input1.nextDouble());
                insuranceCoverageCounter++;// increase the counter of objects in insuranceCoverage array 

            }

        }

        // for loop to print all the objects in cars array in CICSDatabase file
        for (int i = 0; i < cars.length; i++) {
            output1.print(cars[i].toString());
        }

        // for loop to print all the objects in insuranceCoverage array in CICSDatabase file
        for (int i = 0; i < insuranceCoverage.length; i++) {
            output1.print(insuranceCoverage[i].toString());
        }

        // for loop to print all the objects in owners array in CICSDatabase file     
        for (int i = 0; i < owners.length; i++) {
            output1.print(owners[i].toString());
        }

        input1.close();//close the scanner that read from inputCICSData file
        output1.close();// close the printwritter that print in CICSDatabase file

        // the input and the output of the second file //
        File inputClaims = new File("inputClaims.txt");//create a file object to read from it
        if (!inputClaims.exists()) { //check that the file is exist
            System.out.println("The input Claims file does not exist");//display that the file does not exist
            System.exit(0);//exit from the program
        }

        Scanner input2 = new Scanner(inputClaims);//craete another scanner object to read by it from inputClaims file

        File ClaimInvoices = new File("ClaimInvoices.txt");//create a file object to write to it
        PrintWriter output2 = new PrintWriter(ClaimInvoices);//craete another  PrintWriter object to write by it in ClaimInvoices file
        output2.println("--------------- Welcome to Traffic Claim System ---------------\n\n");//print on ClaimInvoices file

        final int NUMBER_OF_CLAIMS = input2.nextInt();//reading the number of claims from inputClaims file
        Claim[] claims = new Claim[NUMBER_OF_CLAIMS];// create a claims array from Claim class type

        String command_inputClaims = "";//craete another command variable to read the command from inputClaims file
        int arrayCounter = 0;//to count the objects in claims array 

        while (!command_inputClaims.equals("Quit")) {//check that the command not equals to Quit --> if false then exit the loop
            command_inputClaims = input2.next();// read the command from inputClaims file 

            if (command_inputClaims.equals("ProcessClaim")) {//check the contents of the command
                //declar a claim object in claims array and invoke GenerateClaim method to create it 
                claims[arrayCounter] = GenerateClaim(input2, insuranceCoverage, cars, owners, output2);
                arrayCounter++;// increase the counter of objects in claims array 
            }

        }

        output2.println("--------Total claim(s) by owner--------\n");//print on ClaimInvoices file
        NumOfInsuranceCoveragesperOwner(owners, claims, output2);// invoke NumOfInsuranceCoveragesperOwner method to print the total claims by owner 
        input2.close();//close the scanner that read from inputClaims file
        output2.close();// close the printwritter that print in ClaimInvoices file
    }

//-------------------------------------------------------------------------------------------    
    //method to get the car object 
    private static Car getCar(Scanner input2, Car[] cars) {
        String numberPlate = input2.next();// read the number plate from the file 
        // for loop to search for the car object associated with the given number plate
        for (int i = 0; i < cars.length; i++) {
            if (String.valueOf(cars[i].getCarPlateNo()).equals(numberPlate)) {
                return cars[i];// return the car object 
            }
        }

        return null;// if we don't find the correct object 

    }

//-------------------------------------------------------------------------------------------    
    //method to get the InsuranceCoverage object 
    private static InsuranceCoverage getInsuranceCoverage(Scanner input2, InsuranceCoverage[] insuranceCoverage) {
        String insuranceCoverageCode = input2.next();// read the insurance Coverage Code from the file 
        // for loop to search for the insurance coverage object associated with the given insurance coverage code
        for (int i = 0; i < insuranceCoverage.length; i++) {
            if (String.valueOf(insuranceCoverage[i].getInsuranceCoverageCode()).equals(insuranceCoverageCode)) {
                return insuranceCoverage[i];// return the InsuranceCoverage object 
            }
        }

        return null;// if we don't find the correct object 

    }

//-------------------------------------------------------------------------------------------    
    //method to get the owner object 
    private static Owner getOwner(Scanner input2, Owner[] owners) {
        String ownerID = input2.next();// read the owner ID from the file 
        // for loop to search for the owner object associated with the given national ID
        for (int i = 0; i < owners.length; i++) {
            if (String.valueOf(owners[i].getNationalID()).equals(ownerID)) {
                return owners[i];// return the owner object 

            }
        }

        return null;// if we don't find the correct object 

    }

//-------------------------------------------------------------------------------------------    
    private static Claim GenerateClaim(Scanner input2, InsuranceCoverage[] insuranceCoverage, Car[] cars, Owner[] owners, PrintWriter output2) {
        //create a Claim object with it's constructor 
        Claim claim = new Claim(System.currentTimeMillis(),//generate a unique 13-digit time stamped invoice number
                getInsuranceCoverage(input2, insuranceCoverage),//invoke getInsuranceCoverage method to get an insuranceCoverage object
                getCar(input2, cars),//invoke getCar method to get a car object
                getOwner(input2, owners),//invoke getOwner method to get an owner object
                input2.next(),// read the location from the file 
                new Date(input2.nextInt(), input2.nextInt(), input2.nextInt()),// read the claimDate from the file 
                input2.nextBoolean(),//read if the claim hasPremium or not
                input2.nextBoolean());//read if the claim hasSpecialOffer or not
        //invoke PrintClaim method to print the claim object in ClaimInvoices file 
        PrintClaim(claim, output2);
        return claim;// return the claim object that created
    }

//-------------------------------------------------------------------------------------------
    //method to print the claim objects in ClaimInvoices file
    public static void PrintClaim(Claim claim, PrintWriter output2) {
        output2.println("Invoice No. " + claim.getClaimNo() + "\n\n"
                + "Insurance Coverage Details\n"
                + "	Insurance Coverage Code: " + claim.getInsuranceCoverage().getInsuranceCoverageCode() + "\n"
                + "	Insurance Coverage Description: " + claim.getInsuranceCoverage().getDescription().replace("_", " ") + "\n"
                + "	Insurance Coverage Penalty: " + claim.getInsuranceCoverage().getAmount() + "\n\n"
                + "Car Details\n"
                + "	Number Plate: " + claim.getCar().getCarPlateNo() + "\n"
                + "	Type: " + claim.getCar().getCarType() + "\n"
                + "	Brand: " + claim.getCar().getBrand() + "\n"
                + "	Model: " + claim.getCar().getCarModel() + "\n"
                + "	Color: " + claim.getCar().getCarColor() + "\n"
                + "	Built Year: " + claim.getCar().getBuiltYear() + "\n\n"
                + "Owner Details\n"
                + "	National ID: " + claim.getOwner().getNationalID() + "\n"
                + "	Full Name: " + claim.getOwner().getFirst_name() + " " + claim.getOwner().getLast_name() + "\n\n"
                + "Claim Details\n"
                + "	Date: " + claim.getClaimDate().getYear() + "-" + claim.getClaimDate().getDate() + "-" + claim.getClaimDate().getMonth() + "\n"
                + "	Location: " + claim.getLocation() + "\n\n"
                + "Total Amount: " + claim.CalculateFinalClaimAmount() + "\n"
                + "───────────────────────────────────────────────────────");
    }

//-------------------------------------------------------------------------------------------    
    //method to calculate the Number Of Insurance Coverages per Owner and print it 
    public static void NumOfInsuranceCoveragesperOwner(Owner[] owners, Claim[] claims, PrintWriter output2) {
        output2.println("Owner ID             Owner Name            Total Claim(s)");//print in ClaimInvoices file 
        for (int i = 0; i < owners.length; i++) {//for loop for all the owners 
            int total = 0;//make the total 0 in the biggining for each owner 
            for (int j = 0; j < claims.length; j++) {//for loop for all the claim
                if (claims[j].getOwner().getNationalID().equals(owners[i].getNationalID())) {
                    total++;// increase the total for the current owner 
                }
            }
            //print the id, name and the total claim for each owner in the file 
            output2.printf("\n%-15s%16s%26d", owners[i].getNationalID(), owners[i].getFirst_name() + " " + owners[i].getLast_name(), total);
        }
    }

}
