package Lab8_DailyStoreReport;

public class Regular extends Customer {

    // define discountRate=0.05 as constant
    private double discountRate = 0.05;

    //-------------------------------------
    public Regular() {
        super();

    }

    //--------------------------------------
    public Regular(String name, double purchasesCost) {
        super(name, purchasesCost);
    }

    //---------------------------------------
    //override getPurchasesCost as requested
    @Override
    public double getPurchasesCost() {
        return (super.getPurchasesCost() - (super.getPurchasesCost() * discountRate));

    }

    //---------------------------------------
    //override toString()as requested
    @Override
    public String toString() {
        return "Regular " + super.toString() + " , cost after discount= " + getPurchasesCost();

    }
}
