package Service;
import java.util.HashMap;
import java.util.Scanner;

public class InventoryService {
    static HashMap<String, Integer> roomCount = new HashMap<>();
    static HashMap<String, Double> roomPrice = new HashMap<>();
    static int roomIdCounter = 100;

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
                   System.out.print("Room Type: ");
                   String type = in.next();
                   System.out.print("Count: ");
                   int count = in.nextInt();
                   System.out.print("Price: ");
                   double price = in.nextDouble();
                  addRoomType(type, count, price);
                   break;
               case 2 :
                   System.out.println("Enter Room Id:");
                   String type1 = in.next();

                   System.out.print("Enter Price:");
                   int count1 = in.nextInt();

                   updateRoomCount(type1, count1);
                   break;
               case 3 :
                   System.out.println("Enter Room Id:");
                   String type2 = in.next();
                   System.out.print("Enter Price");
                   double price2 = in.nextDouble();
                   updatePrice(type2,price2);
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

    // UC1
    public static void addRoomType(String roomType, int count, double price) {
        roomCount.put(roomType, roomCount.getOrDefault(roomType, 0) + count);
        roomPrice.put(roomType, price);
    }

    public static void updateRoomCount(String roomType, int count) {
        roomCount.put(roomType, count);
    }

    public static void updatePrice(String roomType, double price) {
        roomPrice.put(roomType, price);
    }

    public static void displayInventory() {
        roomCount.forEach((type, count) -> {
            System.out.println(type + " Room");
            System.out.println("Available : " + count);
            System.out.println("Price : " + roomPrice.get(type));
            System.out.println("-------------------");
        });
    }

}
