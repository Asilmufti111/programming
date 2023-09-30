
public class Guest  {

    private String Fname;
    private String Lname;
    private char Gender;
    private int ID;
    private double age;

    public Guest(String Fname, String Lname, char Gender, int ID, double age) {
        this.Fname = Fname;
        this.Lname = Lname;
        this.Gender = Gender;
        this.ID = ID;
        this.age = age;
    }

    public double getAge() {
        return age;
    }

    public String getFname() {
        return Fname;
    }

    public String getLname() {
        return Lname;
    }

    public char getGender() {
        return Gender;
    }

    public int getID() {
        return ID;
    }



    public String viewDetails() {
        return "Guest ID :" + ID + "Guest Name :" + Fname + "  " + Lname + " Gender : " + Gender;
    }
}
