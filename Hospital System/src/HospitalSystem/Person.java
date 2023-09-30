
package HospitalSystem;

public class Person implements Comparable<Person> {

    // data fields //
    private int id;
    private String name;
    private String nationality;
    private char gender;
    private int phone;

    // the constructer
    public Person(int id, String name, String nationality, char gender, int phone) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.gender = gender;
        this.phone = phone;
    }

    // getters and setters  //
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public char getGender() {
        return gender;
    }

    public int getPhone() {
        return phone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    // method to return person object information  
    @Override
    public String toString() {
        return "\tID: " + id + "\n"
                + "\tName: " + name + "\n"
                + "\tNationality :" + nationality + "\n"
                + "\tGender: " + gender + "\n"
                + "\tPhone: " + phone + "\n";
    }

    //method to compare between person ids to sort HPerson array 
    @Override
    public int compareTo(Person person) {
        return this.id - person.id;
    }
}
