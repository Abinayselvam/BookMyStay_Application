package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Book My Stay Application");
        System.out.println("Welcome to the MainMenu");
        System.out.print("1.View Inventory\n");
        System.out.print("2.Search Room\n");
        System.out.print("3.Request Booking\n");
        System.out.print("4.Process Booking\n");
        System.out.print("5.View Booking History\n");
        System.out.print("6.Exit\n \n");
        Scanner input = new Scanner(System.in);
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
             default:
                 System.out.println("Exiting..........");
                 break;
        }
    }
}