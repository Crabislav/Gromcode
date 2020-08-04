package lesson15.api;

public class BookingComAPI implements API {
    private Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    //TODO: remove code duplicates
    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int amount = calculateValidRoomsAmount(price, persons, city, hotel);
        Room[] resultRooms = new Room[amount];

        if (!isQueryValid(price, persons) || rooms == null || amount <= 0) {
            return new Room[0];
        }

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
            if (isRoomValid(price, persons, city, hotel, room))
                count++;
        }
        return count;
    }

    private boolean isQueryValid(int price, int persons) {
        return price > 0 && persons > 0;
    }

    //class differs only with this method
    private boolean isRoomValid(int price, int persons, String city, String hotel, Room room) {
        if (price - 100 >= 0 && room != null) {
            return room.getPersons() == persons && room.getHotelName() == hotel && room.getCityName() == city
                    && room.getPrice() >= price - 100 && room.getPrice() <= price + 100;
        } else {
            return false;
        }
    }
}
