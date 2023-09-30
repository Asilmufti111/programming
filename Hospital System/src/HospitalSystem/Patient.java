
package HospitalSystem;

public class Patient extends Person {

    // data fields //
    private String illness;
    private String bloodGroup;
    private Doctor doctor;
    private Medicine[] medicine;
    private Room room;

    // the constructer
    public Patient(String illness, String bloodGroup, int id, String name, String nationality, char gender, int phone, int totalMedicine) {
        super(id, name, nationality, gender, phone);
        this.illness = illness;
        this.bloodGroup = bloodGroup;
        this.medicine = new Medicine[totalMedicine];
    }

    // getters and setters  //
    public int getTotalMedicine() {
        return medicine.length;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Medicine getMedicine(int index) {
        return medicine[index];
    }

    public void setMedicine(Medicine medicine, int index) {
        this.medicine[index] = medicine;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    //method to calculate the total bill for the patient object
    public double calTotalBill() {
        double medicinesBill = 0.0;
        //for loop to calculate the medicines Bill
        for (int i = 0; i < medicine.length; i++) {
            medicinesBill += medicine[i].getPrice();
        }
        //calculate the total bill and return it 
        return doctor.getConsultationFees() + room.getCharges() + medicinesBill;
    }

    //method to print Patient Basic Information 
    public String printPatientBasicInfo() {
        StringBuilder medicinesInfo = new StringBuilder("");
        //for loop to read all medicines Information 
        for (int i = 0; i < medicine.length; i++) {
            medicinesInfo.append("\tMedicine name: " + String.format("%-17s", medicine[i].getName()) + "Price: " + medicine[i].getPrice() + " SR \n");
        }
        //return the Basic Information for the Patient object 
        return "Patient Detail: \n"
                + " ID: " + super.getId() + " Name: " + super.getName() + "\n"
                + "\tDoctor : " + doctor.getName() + "   Doctor Consultation Fees: " + doctor.getConsultationFees() + " SR	\n"
                + "\tMedicines  are:  \n" + medicinesInfo
                + "\tRoom: " + room.getRoomNo() + " Room Charge: " + room.getCharges() + " SR   ";
    }

    // method to return patient object information  
    @Override
    public String toString() {
        return super.toString()
                + "-------------------------------------------------------------------------------------------\n"
                + "Illness: " + illness + ", Blood Group: " + bloodGroup + "\n"
                + "-------------------------------------------------------------------------------------------\n\n";
    }

}
