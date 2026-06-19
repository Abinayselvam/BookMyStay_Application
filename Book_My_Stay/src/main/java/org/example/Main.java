package org.example;
import Service.InventoryService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        do{
            System.out.println("Welcome to the Book My Stay Application");
            System.out.println("Welcome to the MainMenu \n 1.View Inventory\n 2.Search Room\n 3.Request Booking\n 4.Process Booking\n 5.View Booking History\n 6.Exit\n \n");
            System.out.print("Enter the choice: ");
            int choice = input.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("Welcome to the view Inventory");
                    break;
                case 2:
                    System.out.println("Welcome to the search Room");
                    break;
                case 3:
                    System.out.println("Welcome to the Request Booking ");
                    break;
                case 4:
                    System.out.println("Welcome to the Processing Booking ");
                    break;
                case 5:
                    System.out.println("Welcome to the booking history");
                    break;
                case 6:
                    System.out.println("Exiting..........");
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }while(flag);

    }
}