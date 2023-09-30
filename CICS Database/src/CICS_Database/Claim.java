
package CICS_Database;

import java.util.Date;

public class Claim {

    // data fields //
    private long ClaimNo;
    private String location;
    private Date claimDate;
    private Boolean hasPremium;
    private Boolean hasSpecialOffer;
    private Car car;
    private Owner owner;
    private InsuranceCoverage insuranceCoverage;

    // the constructer
    public Claim(long ClaimNo, InsuranceCoverage insuranceCoverage, Car car, Owner owner, String location, Date claimDate, Boolean hasPremium, Boolean hasSpecialOffer) {
        this.ClaimNo = ClaimNo;
        this.insuranceCoverage = insuranceCoverage;
        this.car = car;
        this.owner = owner;
        this.location = location;
        this.claimDate = claimDate;
        this.hasPremium = hasPremium;
        this.hasSpecialOffer = hasSpecialOffer;
    }

    // getters and setters  //
    public long getClaimNo() {
        return ClaimNo;
    }

    public String getLocation() {
        return location;
    }

    public Date getClaimDate() {
        return claimDate;
    }

    public Boolean getHasPremium() {
        return hasPremium;
    }

    public Boolean getHasSpecialOffer() {
        return hasSpecialOffer;
    }

    public Car getCar() {
        return car;
    }

    public Owner getOwner() {
        return owner;
    }

    public InsuranceCoverage getInsuranceCoverage() {
        return insuranceCoverage;
    }

    public void setClaimNo(long ClaimNo) {
        this.ClaimNo = ClaimNo;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
    }

    public void setHasPremium(Boolean hasPremium) {
        this.hasPremium = hasPremium;
    }

    public void setHasSpecialOffer(Boolean hasSpecialOffer) {
        this.hasSpecialOffer = hasSpecialOffer;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setInsuranceCoverage(InsuranceCoverage insuranceCoverage) {
        this.insuranceCoverage = insuranceCoverage;
    }

    // method to Calculate the Final Claim Amount
    public double CalculateFinalClaimAmount() {
        double total = insuranceCoverage.getAmount();//the total is the amount itself
        if (getHasPremium() == true) {//check if the claim  Has Premium
            total += 200;// add 200 to the total
        }
        if (getHasSpecialOffer() == true) {//check if the claim Has Special Offer
            total += 100;// add 100 to the total 
        }

        Date today = new Date();// create a date object
        int currentYear = today.getYear() + 1900;//add 1990 becouse the getYear() method of Java date class returns the value by subtracting 1900 from the year
        int age = currentYear - owner.getDob().getYear();//subtract the year in owner's DOB from the current Year to get the owner's age
        if (age >= 60) {// check if the owner is senior citizen
            total += 50;//add 50 to the total
        }

        return total;//return the total penalty amount 
    }

}
