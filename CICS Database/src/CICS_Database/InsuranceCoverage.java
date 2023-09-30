
package CICS_Database;

public class InsuranceCoverage {

    // data fields //
    private int insuranceCoverageCode;
    private String description;
    private double amount;

    // the constructer
    public InsuranceCoverage(int insuranceCoverageCode, String description, double amount) {
        this.insuranceCoverageCode = insuranceCoverageCode;
        this.description = description;
        this.amount = amount;
    }

    // getters and setters  //
    public int getInsuranceCoverageCode() {
        return insuranceCoverageCode;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public void setNsuranceCoverageCode(int nsuranceCoverageCode) {
        this.insuranceCoverageCode = nsuranceCoverageCode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

// method to return Insurance Coverage object information  
    public String toString() {
        return "\n\n	InsuranceCoverage Code: " + getInsuranceCoverageCode() + "	InsuranceCoverage Description: " + getDescription().replaceAll("_", " ")
                + "\n------------------------------------------------------";

    }

}
