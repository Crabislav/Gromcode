package lesson11.homework;

public class GoogleAPI implements API {
    private Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    //TODO: remove code duplicates
    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int amount = calculateValidRoomsAmount(price, persons, city, hotel);

        if (!isQueryValid(price, persons) || rooms == null || amount <= 0) {
            return null;
        }

        Room[] resultRooms = new Room[amount];

        int index = 0;
        for (Room room : rooms) {
            if (isRoomValid(price, persons, city, hotel, room)) {
                resultRooms[index] = room;
                index++;
            }
        }
        return resultRooms;

    }

    @Override
    public Room[] getAll() {
        return rooms;
    }

    private int calculateValidRoomsAmount(int price, int persons, String city, String hotel) {
        int count = 0;
        for (Room room : rooms) {
            if (isRoomValid(price, persons, city, hotel, room)) {
                count++;
            }
        }
        return count;
    }

    private boolean isQueryValid(int price, int persons) {
        return price > 0 && persons > 0;
    }

    //class differs only with this method
    private boolean isRoomValid(int price, int persons, String city, String hotel, Room room) {
        if (room == null) {
            return false;
        }
        return room.getPrice() == price && room.getPersons() == persons && room.getCityName() == city
                && room.getHotelName() == hotel;
    }
}
