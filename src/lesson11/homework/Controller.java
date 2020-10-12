package lesson11.homework;

public class Controller {
    private API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }

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

    //finds similar rooms among two APIs
    public Room[] check(API api1, API api2) {
        if (api1 == null || api2 == null) {
            return new Room[0];
        }

        int count = 0;

        Room[] roomsAPI1 = api1.getAll();
        Room[] roomsAPI2 = api2.getAll();

        for (Room roomAPI1 : roomsAPI1) {
            for (Room roomAPI2 : roomsAPI2) {
                if (isRoomsSimilar(roomAPI1, roomAPI2)) {
                    count++;
                    break;
                }
            }
        }

        Room[] resultRooms = new Room[count];

        int index = 0;
        for (Room roomAPI1 : roomsAPI1) {
            for (Room roomAPI2 : roomsAPI2) {
                if (isRoomsSimilar(roomAPI1, roomAPI2)) {
                    resultRooms[index] = roomAPI1;
                    index++;
                    break;
                }
            }
        }
        return resultRooms;
    }


    //finds the cheapest room among all APIs
    public Room cheapestRoom() {
        //calculate the whole amount of all rooms
        int allRoomsAmount = calculateRoomsAmount();
        Room[] allRooms = new Room[allRoomsAmount];

        if (allRoomsAmount <= 0) {
            return null;
        }

        int index = 0;
        for (API api : apis) {
            Room[] rooms = api.getAll();
            for (Room room : rooms) {
                allRooms[index] = room;
                index++;
            }
        }

        Room cheapRoom = allRooms[0];
        for (Room room : allRooms) {
            if (room != null && room.getPrice() < cheapRoom.getPrice()) {
                cheapRoom = room;
            }
        }
        return cheapRoom;
    }

    private int calculateRoomsAmount(int price, int persons, String city, String hotel) {
        int count = 0;
        for (API api : apis) {
            if (api != null) {
                count += api.findRooms(price, persons, city, hotel).length;
            }
        }
        return count;
    }

    private int calculateRoomsAmount() {
        int count = 0;
        for (API api : apis) {
            if (api != null) {
                count += api.getAll().length;
            }
        }
        return count;
    }

    private boolean isRoomsSimilar(Room room1, Room room2) {
        if (room1 == null || room2 == null) {
            return false;
        }

        return room1.getPrice() == room2.getPrice() && room1.getCityName() == room2.getCityName()
                && room1.getPersons() == room2.getPersons() && room1.getHotelName() == room2.getHotelName();
    }
}

