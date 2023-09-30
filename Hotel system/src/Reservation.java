
public class Reservation {
    private int ID;
    private HotelUnite HotelUnite;
    private Guest Guest;

    public Reservation(int ID, HotelUnite HotelUnite, Guest Guest) {
        this.ID = ID;
        this.HotelUnite = HotelUnite;
        this.Guest = Guest;
    }
    
    public int getID()
    {
        return ID;
    }
}
