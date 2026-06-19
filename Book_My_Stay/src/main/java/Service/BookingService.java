package Service;
import Entity.Customer;
import Entity.Reservation;
import Entity.Service;

import java.util.*;

public class BookingService {
    private Queue<Reservation> bookingQueue = new LinkedList<>();
    private Set<String> allocatedRooms = new HashSet<>();
    private Map<String, List<Service>> reservationServices = new HashMap<>();
    private int reservationCounter = 1;

    public Reservation createBooking(
            String customerName,
            String roomType) {

        Reservation reservation =
                new Reservation(

                        "R" +
                                reservationCounter++,

                        new Customer(
                                customerName
                        ),

                        roomType
                );

        bookingQueue.offer(
                reservation
        );

        return reservation;
    }

}
