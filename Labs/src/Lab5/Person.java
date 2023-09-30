
public class Person {

    private String fName;
    private String lName;

    Person(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;

    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String toString() {
        return fName + " " + lName;

    }

}
