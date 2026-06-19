package Service;

import Entity.Reservation;

import java.util.ArrayList;
import java.util.List;

public class HistoryService {

    private List<Reservation>
            bookingHistory =
            new ArrayList<>();

    public void addHistory(
            Reservation reservation) {

        bookingHistory.add(
                reservation
        );
    }

    public void showHistory() {

        System.out.println(
                "\nBooking History"
        );

        for(Reservation reservation
                : bookingHistory) {

            System.out.println(

                    reservation.getReservationId()
                            + " | " +

                            reservation.getCustomer()
                                    .getCustomerName()

                            + " | " +

                            reservation.getRoomId()
            );
        }
    }
}