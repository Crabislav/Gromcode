package lesson36.demo;

import lesson36.model.Hotel;
import lesson36.repository.HotelRepository;

public class DemoHotel {
    public static void main(String[] args) {
        HotelRepository hotelRepository = new HotelRepository();

        try {
            hotelRepository.addHotel(Hotel.newInstance("Hotel", "UA", "ZP", "ZAPOROJSKAYA"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
