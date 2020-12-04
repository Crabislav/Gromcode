package lesson36.service;

import lesson36.exceptions.BadRequestException;
import lesson36.model.filter.Filter;
import lesson36.model.Order;
import lesson36.model.Room;
import lesson36.repository.OrderRepository;
import lesson36.repository.RoomRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RoomService extends Service {
    private static final RoomRepository roomRepository = new RoomRepository();
    private static final OrderRepository orderRepository = new OrderRepository();

    public List<Room> findRooms(Filter filter) throws Exception {
        ArrayList<Room> filteredRooms = roomRepository.getAllObjects();

        roomFilter.filterByBreakfast(filter.getBreakfastIncluded(), filteredRooms);
        roomFilter.filterByPetsAllowed(filter.getPetsAllowed(), filteredRooms);
        roomFilter.filterByNumberOfGuests(filter.getNumberOfGuests(), filteredRooms);
        roomFilter.filterByPrice(filter.getPrice(), filteredRooms);
        roomFilter.filterByDateAvailableFrom(filter.getDateAvailableFrom(), filteredRooms);

        roomFilter.filterByHotelName(filter.getName(), filteredRooms);
        roomFilter.filterByHotelCountry(filter.getCountry(), filteredRooms);
        roomFilter.filterByHotelCity(filter.getCity(), filteredRooms);
        roomFilter.filterByHotelStreet(filter.getStreet(), filteredRooms);

        return filteredRooms;
    }

    /**
     * only admins
     */
    public void addRoom(Room room) throws Exception {
        validateRoom(room);
        roomRepository.save(room);
    }

    /**
     * only admins
     */
    public void deleteRoom(long roomId) throws Exception {
        String methodName = "deleteRoom";

        Room room = roomRepository.findObjById(roomId);
        if (room == null) {
            throw new BadRequestException(methodName + ": Room (id=" + roomId + ") wasn't found");
        }

        for (Order order : orderRepository.getAllObjects()) {
            if (order.getRoom().equals(room)) {
                throw new BadRequestException(methodName + ": can't delete already booked room");
            }
        }

        roomRepository.remove(room);
    }

    private void validateRoom(Room room) throws BadRequestException {
        validate(room);
        validate(room.getHotel());
        validate(room.getDateAvailableFrom());
        validate(room.getBreakfastIncluded());
        validate(room.getPetsAllowed());
    }
}
