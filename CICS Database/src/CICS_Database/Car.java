
package CICS_Database;

public class Car {

    // data fields //
    private String CarPlateNo;
    private String CarType;
    private String Brand;
    private String CarModel;
    private String CarColor;
    private int BuiltYear;

    // the constructer
    public Car(String CarPlateNo, String CarType, String Brand, String CarModel, String CarColor, int BuiltYear) {
        this.CarPlateNo = CarPlateNo;
        this.CarType = CarType;
        this.Brand = Brand;
        this.CarModel = CarModel;
        this.CarColor = CarColor;
        this.BuiltYear = BuiltYear;
    }

    // getters and setters  //
    public String getCarPlateNo() {
        return CarPlateNo;
    }

    public String getCarType() {
        return CarType;
    }

    public String getBrand() {
        return Brand;
    }

    public String getCarModel() {
        return CarModel;
    }

    public String getCarColor() {
        return CarColor;
    }

    public int getBuiltYear() {
        return BuiltYear;
    }

    public void setCarPlateNo(String CarPlateNo) {
        this.CarPlateNo = CarPlateNo;
    }

    public void setCarType(String CarType) {
        this.CarType = CarType;
    }

    public void setBrand(String Brand) {
        this.Brand = Brand;
    }

    public void setCarModel(String CarModel) {
        this.CarModel = CarModel;
    }

    public void setCarColor(String CarColor) {
        this.CarColor = CarColor;
    }

    public void setBuiltYear(int BuiltYear) {
        this.BuiltYear = BuiltYear;
    }

// method to return car object information  
    public String toString() {
        return "\n\n	Car No.: " + getCarPlateNo() + "	Type: " + getCarType()
                + "	Brand: " + getBrand() + "	Model: " + getCarModel() + "	Color: " + getCarColor() + "	Mfg. Year: " + getBuiltYear()
                + "\n------------------------------------------------------";
    }

}
