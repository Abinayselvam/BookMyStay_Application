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

    public void processBooking(
            InventoryService inventory,
            HistoryService history) {

        if (bookingQueue.isEmpty()) {

            System.out.println(
                    "No Pending Bookings"
            );

            return;
        }

        Reservation reservation =
                bookingQueue.poll();

        if (!inventory.isAvailable(
                reservation.getRoomType()
        )) {

            System.out.println(
                    "Room Not Available"
            );

            return;
        }

        String roomId =

                reservation.getRoomType()
                        .substring(0, 1)
                        .toUpperCase()

                        +

                        (100 +
                                allocatedRooms.size());

        allocatedRooms.add(
                roomId
        );

        reservation.setRoomId(
                roomId
        );

        inventory.reduceRoomCount(
                reservation.getRoomType()
        );

        history.addHistory(
                reservation
        );

        System.out.println(

                "\nBooking Confirmed"
                        +
                        "\nReservation ID : "
                        +
                        reservation.getReservationId()
                        +
                        "\nRoom ID : "
                        +
                        roomId
        );
    }
    public void addService(
            Reservation reservation,
            Service service) {

        reservationServices

                .computeIfAbsent(

                        reservation
                                .getReservationId(),

                        k -> new ArrayList<>()
                )

                .add(service);
    }
    public void showServices(
            Reservation reservation) {

        System.out.println(

                reservationServices.get(
                        reservation
                                .getReservationId()
                )
        );
    }



}
