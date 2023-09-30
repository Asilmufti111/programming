
package HospitalSystem;

public class Room {

    // data fields //
    private int roomNo;
    private String floor;
    private String block;
    private double charges;

    // the constructer
    public Room(int roomNo, String floor, String block, double charges) {
        this.roomNo = roomNo;
        this.floor = floor;
        this.block = block;
        this.charges = charges;
    }

    // getters and setters  //
    public int getRoomNo() {
        return roomNo;
    }

    public String getFloor() {
        return floor;
    }

    public String getBlock() {
        return block;
    }

    public double getCharges() {
        return charges;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public void setCharges(double charges) {
        this.charges = charges;
    }

    // method to return room object information  
    @Override
    public String toString() {
        return "\tRoom No: " + roomNo + "\n"
                + "\tLocated in floor: " + floor + "\n"
                + "\tBlock :" + block + "\n"
                + "\tCharges: " + charges + "\n";
    }

}
