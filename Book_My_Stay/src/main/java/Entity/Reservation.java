package Entity;

import java.util.ArrayList;
import java.util.List;

public class Reservation {

    private String reservationId;
    private Customer customer;
    private String roomType;
    private String roomId;

    private List<Service>
            services =
            new ArrayList<>();

    public Reservation(
            String reservationId,
            Customer customer,
            String roomType) {

        this.reservationId = reservationId;
        this.customer = customer;
        this.roomType = roomType;
    }

    public String getReservationId() {
        return reservationId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(
            String roomId) {

        this.roomId = roomId;
    }

    public List<Service>
    getServices() {

        return services;
    }
}