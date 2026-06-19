package Entity;

public class Room {
    private String id;
    private String roomType;
    private double price;
    public Room(String  id,String roomType, double price) {
        this.id = id;
        this.roomType = roomType;
        this.price = price;
    }
    public String getId() {
        return id;
    }
    public String getRoomType() {
        return roomType;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}


