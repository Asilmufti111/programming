
public class Suite extends HotelUnite {

    private int NumberOfRoom;
    private int NumberOfBathrooms;
    

    
    public Suite(int Id, double Price, int NumberOfRoom,int NumberOfBathrooms){
        super(Id, Price);
        this.NumberOfRoom=NumberOfRoom;
        this.NumberOfBathrooms=NumberOfBathrooms;
    }
    
  
  
    

   @Override
    public String toString()
    {
        return super.toString()+" Number Of Room in the suite: " +NumberOfRoom+" Number Of Bathrooms in the suite: " +NumberOfBathrooms;
    }
    
}