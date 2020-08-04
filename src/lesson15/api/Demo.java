package lesson15.api;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Room[] emptyRoomArray = new Room[5];

        //GoogleAPI Test
        Room room1 = new Room(1, 100, 2, new Date(), "Hotel", "City");
        Room room2 = new Room(2, 100, 2, new Date(), null, "City");
        Room room3 = null;
        Room room4 = new Room(4, 1100, 2, new Date(), null, "City");
        Room room5 = new Room(5, 50, 2, new Date(), "Hotel", null);

        Room[] rooms = new Room[]{room1, room2, room3, room4, room5};

        GoogleAPI googleAPI = new GoogleAPI(rooms);
        GoogleAPI emptyGoogleAPI = new GoogleAPI(emptyRoomArray);

        BookingComAPI BookingComAPI = new BookingComAPI(rooms);
        lesson15.api.BookingComAPI emptyBookingComAPI = new BookingComAPI(emptyRoomArray);

        TripAdvisorAPI tripAdvisorAPI = new TripAdvisorAPI(rooms);
        TripAdvisorAPI emptyTripAdvisorAPI = new TripAdvisorAPI(emptyRoomArray);


        printDivider();
        System.out.println("API Test");
        printDivider();

        API[] apis = new API[]{googleAPI, emptyGoogleAPI, emptyTripAdvisorAPI, tripAdvisorAPI, BookingComAPI, emptyBookingComAPI};
        Controller controller = new Controller(apis);

        //requestRooms test
        //usual query +
        System.out.println("\ncorrect query");
        System.out.println(Arrays.toString(controller.requestRooms(100, 2, "City", "Hotel")));
        //negative price +
        System.out.println("\nnegative price");
        System.out.println(Arrays.toString(controller.requestRooms(-100, 2, "City", "Hotel")));
        //city is null +
        System.out.println("\ncity is null");
        System.out.println(Arrays.toString(controller.requestRooms(50, 2, null, "Hotel")));
        //hotel is null +
        System.out.println("\nhotel is null");
        System.out.println(Arrays.toString(controller.requestRooms(100, 2, "City", null)));


        //cheapestRoom test
        System.out.println(controller.cheapestRoom());

        //check test
        //normal usage +
        System.out.println(Arrays.toString(controller.check(googleAPI, tripAdvisorAPI)));
        //first param is null +
        System.out.println(Arrays.toString(controller.check(null, tripAdvisorAPI)));
        //second param is null +
        System.out.println(Arrays.toString(controller.check(googleAPI, null)));
        //check one empty and one not +
        System.out.println(Arrays.toString(controller.check(emptyGoogleAPI, tripAdvisorAPI)));
        //check empty api +
        System.out.println(Arrays.toString(controller.check(emptyGoogleAPI, emptyGoogleAPI)));
        //similar types of api input +
        System.out.println(Arrays.toString(controller.check(googleAPI, googleAPI)));

    }

    private static void printDivider() {
        for (int i = 0; i < 50; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}
