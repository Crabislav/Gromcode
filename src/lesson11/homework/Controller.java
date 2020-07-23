package lesson11.homework;

public class Controller {
    private API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }

    //TODO: finish up requestRooms method
    //finds rooms among all APIs
    public Room[] requestRooms(int price, int persons, String city, String hotel) {
        int amount = calculateRoomsAmount(price, persons, city, hotel);
        Room[] resultRooms = new Room[amount];

        if (amount <= 0) {
            return new Room[0];
        }

        int index = 0;
        for (API api : apis) {
            Room[] rooms = api.findRooms(price, persons, city, hotel);
            for (Room room : rooms) {
                resultRooms[index] = room;
                index++;
            }
        }
        return resultRooms;
    }

    /*//TODO: finish up check method
    //finds similar rooms among two APIs and adds them to the first API's array
    public Room[] check(API api1, API api2) {
        return;
    }

    //TODO: finish up cheapestRoom method
    //find the cheapest room among all APIs
    public Room cheapestRoom() {
        for (API api : apis) {

        }
    }*/

    private int calculateRoomsAmount(int price, int persons, String city, String hotel) {
        int count = 0;
        for (API api : apis) {
            if (api != null) {
                count += api.findRooms(price, persons, city, hotel).length;
            }
        }
        return count;
    }
}

