
package HospitalSystem;

public class Medicine {

    // data fields //
    private int medicineCode;
    private String name;
    private double price;

    // the constructer
    public Medicine(int medicineCode, String name, double price) {
        this.medicineCode = medicineCode;
        this.name = name;
        this.price = price;
    }

    // getters and setters  //
    public int getMedicineCode() {
        return medicineCode;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setMedicineCode(int medicineCode) {
        this.medicineCode = medicineCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // method to return medicine object information  
    @Override
    public String toString() {
        return "\tMedicine Code: " + medicineCode + "\n"
                + "\tName: " + name + "\n"
                + "\tPrice :" + price + "\n\n";
    }

}
