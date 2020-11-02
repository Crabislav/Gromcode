package gromcode.main.lesson15.api;

import java.util.Date;

public class GoogleAPI implements API {
    private Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        //no available rooms or negative price/persons - go out from method
        if (rooms == null || !isQueryValid(price, persons)) {
            return new Room[0];
        }

        //room obj which will be used with equals method
        Room roomToFind = new Room(0, price, persons, new Date(), hotel, city);

        //calculates result array's length
        int count = 0;
        for (Room room : rooms) {
            //if room == null -  the next 'if' statement will throw NullPointer
            if (room == null) {
                break;
            }
            if (room.getCityName() == null || room.getHotelName() == null) {
                break;
            }
            //changed to equals here
            if (roomToFind.equals(room)) {
                count++;
            }
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
            //if room == null -  the next 'if' statement will throw NullPointer
            if (room == null) {
                continue;
            }
            //changed to equals here
            if (roomToFind.equals(room)) {
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
}
