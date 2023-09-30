
public class Room extends HotelUnite{
   
    private String RoomType;

    
    public Room(int Id, double Price, String RoomType){
        super(Id, Price);
        this.RoomType=RoomType;   
    }
    
  
    
    @Override
    public String toString()
    {
        return super.toString()+" Room Type : " +RoomType;
    }
    
}
