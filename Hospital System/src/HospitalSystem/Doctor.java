
package HospitalSystem;

public class Doctor extends Staff {

    //data field  
    private double consultationFees;

    // the constructer
    public Doctor(double consultationFees, String staffid, String specialization, int id, String name, String nationality, char gender, int phone) {
        super(specialization, staffid, id, name, nationality, gender, phone);
        this.consultationFees = consultationFees;
    }

    // getters and setters  //
    public double getConsultationFees() {
        return consultationFees;
    }

    public void setConsultationFees(double consultationFees) {
        this.consultationFees = consultationFees;
    }

    // method to return doctor object information 
    @Override
    public String toString() {
        return super.toString()
                + "\tConsultation Fees :" + consultationFees + "\n\n";
    }

}
