package lesson11.homework;

import java.util.Arrays;
import java.util.Date;

public class DemoHomework {
    public static void main(String[] args) {
        Room[] emptyRoomArray = new Room[5];

        //GoogleAPI Test
        Room room1 = new Room(1, 150, 2, new Date(), "Hotel", "City");
        Room room2 = new Room(2, 100, 2, new Date(), "Hotel", "City");
        Room room3 = new Room(3, 150, 2, new Date(), "Hotsadel", "City");
        Room room4 = new Room(4, 100, 2, new Date(), "Hotel", "Citdy");
        Room room5 = new Room(5, 100, 2, new Date(), "Hotel", "City");

        Room[] rooms = new Room[]{room1, room2, room3, room4, room5};
        GoogleAPI googleAPI = new GoogleAPI(rooms);

        printDivider();
        System.out.println("GoogleAPI Test");
        printDivider();

        System.out.println(Arrays.toString(googleAPI.findRooms(100, 2, "City", "Hotel")));
        System.out.println("\n");

        GoogleAPI googleAPI1 = new GoogleAPI(emptyRoomArray);
        System.out.println(Arrays.toString(googleAPI1.findRooms(100, 2, "City", "Hotel")));
        System.out.println("\n");

        //TripAdvisor Test
        Room room11 = new Room(1, 100, 6, new Date(), "Hotel", "City");
        Room room22 = new Room(2, 100, 2, new Date(), "Hotel", "City");
        Room room33 = new Room(3, 100, 2, new Date(), "Hotel", "City");
        Room room44 = new Room(4, 100, 3, new Date(), "Hotel", "City");
        Room room55 = new Room(5, 100, 4, new Date(), "Hotel", "City");


        Room[] rooms1 = new Room[]{room11, room22, room33, room44, room55};
        TripAdvisorAPI tripAdvisorAPI = new TripAdvisorAPI(rooms1);

        printDivider();
        System.out.println("TripAdvisor Test");
        printDivider();
        System.out.println(Arrays.toString(tripAdvisorAPI.findRooms(100, 2, "City", "Hotel")));
        System.out.println("\n");


        TripAdvisorAPI tripAdvisorAPI1 = new TripAdvisorAPI(emptyRoomArray);
        System.out.println(Arrays.toString(tripAdvisorAPI1.findRooms(100, 2, "City", "Hotel")));
        System.out.println("\n");

    }

    private static void printDivider() {
        for (int i = 0; i < 50; i++) {
            System.out.print("-");
        }
        System.out.println();
    }


}
