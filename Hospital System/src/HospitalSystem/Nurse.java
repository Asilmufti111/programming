
package HospitalSystem;

public class Nurse extends Staff {

    // data field
    private int experience;

    // the constructer
    public Nurse(int experience, String staffid, String specialization, int id, String name, String nationality, char gender, int phone) {
        super(specialization, staffid, id, name, nationality, gender, phone);
        this.experience = experience;
    }

    // getters and setters  //
    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    // method to return nurse object information  
    @Override
    public String toString() {
        return super.toString()
                + "\tExperience Year: " + experience + "\n\n";
    }

}
