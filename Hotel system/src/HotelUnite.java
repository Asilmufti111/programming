
public class HotelUnite {

    protected int Id;
    protected double Price;
    protected boolean Available;
    
    public HotelUnite(int Id, double Price){
        this.Id=Id;
        this.Price=Price;
        this.Available=true;   
    }
    

  

    public int getId() {
        return Id;
    }

    public double getPrice() {
        return Price;
    }

    public boolean isAvailable() {
        return Available;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public void setAvailable(boolean Status) {
        this.Available = Status;
    }

    
    

    public String toString() {
        return "Unite ID :" + Id + " Price :" + Price + " Status : " + Available;
    }


}
