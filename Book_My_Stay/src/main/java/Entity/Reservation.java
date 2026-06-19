package Entity;

public class Reservation {
    private String reservationId;
    private String customerName;
    private String roomType;
    public Reservation(String reservationId, String customerName, String roomType) {
        this.reservationId = reservationId;
        this.customerName = customerName;
        this.roomType = roomType;
    }
    public String getReservationId() {
        return reservationId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public String getRoomType() {
        return roomType;
    }
}
