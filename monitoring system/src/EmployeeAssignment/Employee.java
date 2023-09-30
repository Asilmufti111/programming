
//Assigment title: prodects assignment monitoring system
//Assigment date thursday sep 29, 20022

package EmployeeAssignment;

public class Employee {
    
    //data filed 
    private String id;
    private String fName;
    private String lName;
    private int centerNum;
    private int age;
    private String phoneNum;
    private String product;
    private Employee next;

    // CONSTRUCTORS
    public Employee() {
        id = "";
        fName = "";
        lName = "";
        centerNum = 0;
        age = 0;
        phoneNum = "";
        product = "";
        next = null;
    }

    public Employee(String id, String fName, String lName, int centerNum, int age, String phoneNum, String product) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.centerNum = centerNum;
        this.age = age;
        this.phoneNum = phoneNum;
        this.product = product;
        next = null;
    }

    public Employee(String id, String fName, String lName, int centerNum, int age, String phoneNum, String product, Employee next) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.centerNum = centerNum;
        this.age = age;
        this.phoneNum = phoneNum;
        this.product = product;
        this.next = next;
    }

    // ACCESSORS
    public String getId() {
        return id;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public int getCenterNum() {
        return centerNum;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getProduct() {
        return product;
    }

    public Employee getNext() {
        return next;
    }

    // MUTATORS
    public void setId(String id) {
        this.id = id;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setCenterNum(int centerNum) {
        this.centerNum = centerNum;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setNext(Employee next) {
        this.next = next;
    }

}
