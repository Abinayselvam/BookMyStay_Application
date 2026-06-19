package Service;

import Entity.Room;

import java.util.HashMap;
import java.util.Scanner;

public class InventoryService {
    static HashMap<String, Room> rooms = new HashMap<>();
    private static int roomCounter=100;
    static Room room;

   public static void inventoryMain() {

       Scanner in = new Scanner(System.in);

       boolean flag = true;
       do{
           System.out.println("Welcome to the inventory Management \n  1. Add Room \n  2. Add Price \n  3. Update Price \n  4. Display Inventory \n  5. Exit");
           System.out.print("Enter choice : ");
           int choice1 = in.nextInt();
           switch(choice1)
           {
               case 1 :
                   System.out.println("Room Type: ");
                   String roomType = in.next();
                   System.out.println("Enter Price: ");
                   double price = in.nextDouble();

                   addRoom(roomType,price);
                   break;
               case 2 :
                   System.out.println("Enter Room Id:");
                   String type = in.next();

                   System.out.print("Enter Price:");
                   double price1 = in.nextDouble();

                   addPrice(type, price1);
                   break;
               case 3 :
                   System.out.println("Enter Room Id:");
                   String type1 = in.next();
                   System.out.print("Enter Price");
                   double price2 = in.nextDouble();
                   updatePrice(type1,price2);
                   break;
               case 4 :
                   displayInventory();
                   break;
               case 5:
                   System.out.println("Exiting...");
                   flag = false;
                   break;

               default:
                   System.out.println("Invalid Choice!");

           }
       }while(flag);

   }
   public static void addRoom(String roomType, double price) {
       String roomId = "R"+roomCounter++;
       Room room = new Room(roomId,roomType,price);
       rooms.put(roomId,room);
       System.out.println("Successfully added Room");
       System.out.println("Room ID: "+roomId);

   }
    public static void displayInventory() {

        rooms.forEach((id, room) -> {
            System.out.println(
                    "Room ID: " + room.getId() +"\n" +
                            "Room Type: " + room.getRoomType()+"\n"  +
                            "Price: " + room.getPrice() + "\n"
            );
        });
    }
    public static void addPrice(String roomId, double price) {

        if (rooms.containsKey(roomId)) {

            Room room = rooms.get(roomId);
            room.setPrice(price);

            System.out.println("Price updated successfully for Room ID: " + room.getId());

        } else {
            System.out.println("Room ID not found!");
        }
    }
    public static void updatePrice(String roomId, double newPrice) {

        if (rooms.containsKey(roomId)) {

            rooms.get(roomId).setPrice(newPrice);

            System.out.println(
                    "Successfully updated the price of Room ID "
                            + roomId + " to " + newPrice);

        } else {
            System.out.println("Room ID not found!");
        }
    }



}
