package lesson15.api;

import java.util.Date;

public class BookingComAPI implements API {
    private Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        //no available rooms or negative price/persons - go out from method
        if (rooms == null || !isQueryValid(price, persons)) {
            return new Room[0];
        }

        //calculates result array's length
        int count = 0;
        for (Room room : rooms) {
            if (isRoomValid(price, persons, city, hotel, room))
                count++;
        }

        //result array's length should be at least 1
        if (count <= 0) {
            return new Room[0];
        }

        //this array will be returned by this method
        Room[] resultRooms = new Room[count];

        //result array filled here
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

    //self-explanatory
    private boolean isQueryValid(int price, int persons) {
        return price > 0 && persons > 0;
    }

    //used instead of equals
    private boolean isRoomValid(int price, int persons, String city, String hotel, Room room) {
        if (price - 100 >= 0 && room != null) {
            return room.getPersons() == persons && room.getHotelName() == hotel && room.getCityName() == city
                    && room.getPrice() >= price - 100 && room.getPrice() <= price + 100;
        } else {
            return false;
        }
    }
}
