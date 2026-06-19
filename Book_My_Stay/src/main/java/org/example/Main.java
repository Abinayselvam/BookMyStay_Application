package org.example;
import Entity.Reservation;
import Entity.Service;
import Service.BookingService;
import Service.HistoryService;
import Service.InventoryService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        InventoryService inventory =
                new InventoryService();

        BookingService booking =
                new BookingService();

        HistoryService history =
                new HistoryService();

        // Initial Inventory

        inventory.addRoomType("Single", 5, 2500);
        inventory.addRoomType("Double", 3, 4000);
        inventory.addRoomType("Suite", 2, 8000);

        Reservation currentReservation = null;

        int choice;

        do {

            System.out.println("\n===== BOOK MY STAY =====");

            System.out.println("1. View Rooms");
            System.out.println("2. Create Booking");
            System.out.println("3. Confirm Booking");
            System.out.println("4. Add Breakfast");
            System.out.println("5. Add Airport Pickup");
            System.out.println("6. View Services");
            System.out.println("7. View Booking History");
            System.out.println("8. Exit");

            System.out.print("Enter Choice : ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    inventory.displayInventory();
                    break;

                case 2:

                    System.out.print("Customer Name : ");
                    String customerName =
                            scanner.nextLine();

                    System.out.print("Room Type (Single/Double/Suite) : ");
                    String roomType =
                            scanner.nextLine();

                    currentReservation =
                            booking.createBooking(
                                    customerName,
                                    roomType
                            );

                    System.out.println(
                            "Booking Request Added To Queue"
                    );

                    break;

                case 3:

                    booking.processBooking(
                            inventory,
                            history
                    );

                    break;

                case 4:
                    if(currentReservation != null) {

                        booking.addService(
                                currentReservation,

                                new Service(
                                        "Breakfast",
                                        500
                                )
                        );


                        System.out.println(
                                "Breakfast Added"
                        );
                    }
                    else {

                        System.out.println(
                                "Create Booking First"
                        );
                    }

                    break;

                case 5:

                    if(currentReservation != null) {

                        booking.addService(
                                currentReservation,

                                new Service(
                                        "Airport Pickup",
                                        1000
                                )
                        );

                        System.out.println(
                                "Airport Pickup Added"
                        );
                    }
                    else {

                        System.out.println(
                                "Create Booking First"
                        );
                    }

                    break;

                case 6:

                    if(currentReservation != null) {

                        booking.showServices(
                                currentReservation
                        );
                    }
                    else {

                        System.out.println(
                                "No Booking Available"
                        );
                    }

                    break;

                case 7:

                    history.showHistory();
                    break;

                case 8:

                    System.out.println(
                            "Thank You For Using BookMyStay"
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid Choice"
                    );
            }

        } while(choice != 8);

        scanner.close();
    }
}