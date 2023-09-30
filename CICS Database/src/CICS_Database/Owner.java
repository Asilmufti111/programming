
package CICS_Database;

import java.util.Date;

public class Owner {

    // data fields //
    private String nationalID;
    private String First_name;
    private String Last_name;
    private Date dob;

    // the constructer
    public Owner(String nationalID, String First_name, String Last_name, Date dob) {
        this.nationalID = nationalID;
        this.First_name = First_name;
        this.Last_name = Last_name;
        this.dob = dob;
    }

    // getters and setters  //
    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public String getFirst_name() {
        return First_name;
    }

    public void setFirst_name(String First_name) {
        this.First_name = First_name;
    }

    public String getLast_name() {
        return Last_name;

    }

    public void setLast_name(String Last_name) {
        this.Last_name = Last_name;
    }

    public Date getDob() {
        return dob;

    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

// method to return Owner object information  
    public String toString() {
        return "\n\n	Owner ID: " + getNationalID() + "	Name: " + getFirst_name() + " " + getLast_name()
                + "\n------------------------------------------------------";

    }
}
