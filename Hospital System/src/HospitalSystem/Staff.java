
package HospitalSystem;

public abstract class Staff extends Person {

    // data fields //
    private String specialization;
    private String staffid;

    // the constructer
    public Staff(String specialization, String staffid, int id, String name, String nationality, char gender, int phone) {
        super(id, name, nationality, gender, phone);
        this.specialization = specialization;
        this.staffid = staffid;
    }

    // getters and setters  //
    public String getSpecialization() {
        return specialization;
    }

    public String getStaffid() {
        return staffid;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }

    // method to return staff object information  
    @Override
    public String toString() {
        return super.toString()
                + "\tSpecilaization: " + specialization + "\n"
                + "\tStaff ID: " + staffid + "\n";
    }

}
