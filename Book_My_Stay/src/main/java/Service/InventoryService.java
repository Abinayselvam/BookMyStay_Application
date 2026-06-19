package Service;

import java.util.HashMap;

public class InventoryService {

    private HashMap<String,Integer> roomCount = new HashMap<>();

    private HashMap<String,Double> roomPrice = new HashMap<>();

    public void addRoomType(
            String roomType,
            int count,
            double price) {

        roomCount.put(
                roomType,
                count
        );

        roomPrice.put(
                roomType,
                price
        );
    }

    public boolean isAvailable(
            String roomType) {

        return roomCount.getOrDefault(
                roomType,
                0
        ) > 0;
    }

    public void reduceRoomCount(
            String roomType) {

        roomCount.put(
                roomType,
                roomCount.get(roomType)-1
        );
    }

    public double getPrice(
            String roomType) {

        return roomPrice.get(roomType);
    }

    public void displayInventory() {

        System.out.println(
                "\nAvailable Rooms"
        );

        roomCount.forEach(

                (type,count) ->

                        System.out.println(

                                type +
                                        " | Count : "
                                        + count +
                                        " | Price : ₹"
                                        + roomPrice.get(type)
                        )
        );
    }
}