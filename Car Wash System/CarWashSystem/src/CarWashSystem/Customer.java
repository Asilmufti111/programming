
//course number: CPCS204
//date: 9 NOV 2022


package CarWashSystem;

// Customer.java



public class Customer{
	
	    
	    private String firstName;
	    private String lastName; 
	    private String serviceName;
	    private int BN;
	    private Customer next;
	    
	    /* Constructor */
	    public Customer() {
	        next = null;
	    }

	    public Customer(String fname, String lname, String SN, int billNum, Customer next) {
	        this.firstName = fname;
	        this.lastName = lname;
	        this.serviceName = SN;
	        this.BN = billNum; 
	        this.next=next;
	    }

	    /* Getter methods */ 
	   
	    public String getFirstName() {
	        return firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public String getserviceName() {
	        return serviceName;
	    }

	    public int getBN() {
	        return BN;
	    }
            
	    public Customer getNext() {
	        return next;
	    }
	    
	    /* Setter methods*/ 

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

	    public void setserviceName(String serviceName) {
	        this.serviceName = serviceName;
	    }

	    public void setBN(int BN) {
	        this.BN = BN;
	    }
            

	    public void setNext(Customer next) {
	        this.next = next;
	    }

	    
	  
	    
	}// end Customer


