
//Assigment title: prodects assignment monitoring system
//Assigment date thursday sep 29, 20022

package EmployeeAssignment;

import java.io.PrintWriter;

public class Center {
    // head: reference variable to the first node of the list

    private String centerName;
    private Employee head;

    // CONSTRUCTORS
    public Center() {
        head = null;
    }

    //isEmpty method: checke if the list is empty or not 
    public boolean isEmpty() {
        return head == null;
    }

    //accses to the head
    public Employee getHead() {
        return head;
    }

    // void | add(int)
    public void add(String id, String fName, String lName, int centerNum, int age, String phoneNum, String product, String centerName) {
        head = add(head, id, fName, lName, centerNum, age, phoneNum, product);
        this.centerName = centerName;
    }

    // Employee | add(Employee, all datas)
    private Employee add(Employee head, String id, String fName, String lName, int centerNum, int age, String phoneNum, String product) {

        if (head == null) {//add to the first 
            head = new Employee(id, fName, lName, centerNum, age, phoneNum, product, head);
            return head;
        } // ELSE, add it at last
        else {

            // We need to traverse to the last node...so we need a help ptr
            Employee helpPtr = head;
            // Traverse to the last point
            while (helpPtr.getNext() != null) {
                helpPtr = helpPtr.getNext();
            }
            // Now make the new node. Set its next to point to the successor node.
            // And then make the predecessor node point to the new node
            helpPtr.setNext(new Employee(id, fName, lName, centerNum, age, phoneNum, product, null));

            // Return head
            return head;
        }
    }

    //search for an employee based on his/her id
    public Employee search(String id) {
        return search(head, id);
    }

    //search for an employee based on his/her id with head parameter
    private Employee search(Employee head, String id) {
        //help pointer to traverse in the list 
        Employee helpPtr = head;
        while (helpPtr != null) {//move to the last node
            if (helpPtr.getId().equals(id)) {//check if the ids are the same 
                return helpPtr;// return the node of the id
            }
            helpPtr = helpPtr.getNext();//move to the next node
        }
        return helpPtr;// return null if we didn't find the id
    }

    //delete an employee from the list based on his/her id
    public void delete(String id) {
        head = delete(head, id);
    }

    //delete an employee from the list based on his/her id with head parameter
    private Employee delete(Employee head, String id) {
        // We can only delete if the list has nodes (is not empty)
        if (!isEmpty()) {
            // IF the first node (at the head) has the id number we are wanting to delete
            // we found it. Delete by skipping the node and making head point to the next node.
            if (head.getId().equals(id)) {
                head = head.getNext();
            } // ELSE, the data is perhaps somewhere else in the list...so we must traverse and look for it
            else {
                // We need to traverse to find the data we want to delete...so we need a help ptr
                Employee helpPtr = head;
                // Traverse to correct deletion point
                while (helpPtr.getNext() != null) {
                    if (helpPtr.getNext().getId().equals(id)) {//check if i find the id i want to delete or not yet
                        helpPtr.setNext(helpPtr.getNext().getNext());//deleting the node by changing the poiter of the predecessor
                        break; // we deleted the value and should break out of the while loop
                    }
                    helpPtr = helpPtr.getNext();
                }
            }
            // return the possibly updated head of the list
            return head;
        }
        return head;
    }

    //method to print all employees in all centers assigned to the specified prodect
    public void printBaseOnProdect(String prodect, PrintWriter output) {
        //help ptr to traverse in the list 
        Employee helpptr = head;
        while (helpptr != null) {// till the end of the list 
            if (helpptr.getProduct().equals(prodect)) {//check if the prodect is the same as a specified prodect that i want to print
                output.println("\t" + helpptr.getId() + "\t\t" + helpptr.getfName() + " " + helpptr.getlName() + "\t\t" + this.centerName);// print employee information 
            }
            helpptr = helpptr.getNext();// move the pointer to the next  node 
        }

    }
}
