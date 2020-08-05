package lesson15.api;

public class Controller {
    private API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }

    //finds rooms among all APIs
    public Room[] requestRooms(int price, int persons, String city, String hotel) {
        //no apis or negative price/persons - go out from method
        if (apis == null || !isQueryValid(price, persons)) {
            return new Room[0];
        }

        //calculates result array's length
        int count = 0;
        for (API api : apis) {
            if (api != null) {
                count += api.findRooms(price, persons, city, hotel).length;
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
        //null input check
        if (api1 == null || api2 == null) {
            return new Room[0];
        }

        //variable for result array's length
        int count = 0;

        Room[] roomsAPI1 = api1.getAll();
        Room[] roomsAPI2 = api2.getAll();

        //calculates result array's length
        for (Room roomAPI1 : roomsAPI1) {
            for (Room roomAPI2 : roomsAPI2) {
                if (roomAPI1 == null || roomAPI2 == null) {
                    continue;
                }
                //changed to equals here
                if (roomAPI1.equals(roomAPI2)) {
                    count++;
                }
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
        for (Room roomAPI1 : roomsAPI1) {
            for (Room roomAPI2 : roomsAPI2) {
                if (roomAPI1 == null || roomAPI2 == null) {
                    continue;
                }
                //changed to equals here
                if (roomAPI1.equals(roomAPI2)) {
                    resultRooms[index] = roomAPI1;
                    index++;
                }
            }
        }
        return resultRooms;
    }


    //finds the cheapest room among all APIs
    public Room cheapestRoom() {
        //calculates the whole amount of all rooms
        int allRoomsAmount = 0;
        for (API api : apis) {
            if (api != null) {
                allRoomsAmount += api.getAll().length;
            }
        }

        //array with all rooms - empty. only with proper length
        Room[] allRooms = new Room[allRoomsAmount];

        //no rooms - go out from method
        if (allRoomsAmount <= 0) {
            return null;
        }

        //array with all rooms filled here
        int index = 0;
        for (API api : apis) {
            Room[] rooms = api.getAll();
            for (Room room : rooms) {
                allRooms[index] = room;
                index++;
            }
        }

        //we guess that the first slot of array with all rooms is the cheapest
        Room cheapRoom = allRooms[0];

        //the cheapest room finds out here
        for (Room room : allRooms) {
            if (room != null && room.getPrice() < cheapRoom.getPrice()) {
                cheapRoom = room;
            }
        }
        return cheapRoom;
    }

    //self-explanatory
    private boolean isQueryValid(int price, int persons) {
        return price > 0 && persons > 0;
    }
}

