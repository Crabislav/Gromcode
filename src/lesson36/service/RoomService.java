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

public class RoomService {
    private RoomFilter roomFilter = new RoomFilter();
    private RoomRepository roomRepository = new RoomRepository();
    private OrderRepository orderRepository = new OrderRepository();

    public RoomService() throws IOException {
    }

    public List<Room> findRooms(Filter filter) throws Exception {
        ArrayList<Room> filteredRooms = roomRepository.getAllObjects();

        //Room's fields
        roomFilter.filterByBreakfast(filter.getBreakfastIncluded(), filteredRooms);
        roomFilter.filterByPetsAllowed(filter.getPetsAllowed(), filteredRooms);
        roomFilter.filterByNumberOfGuests(filter.getNumberOfGuests(), filteredRooms);
        roomFilter.filterByPrice(filter.getPrice(), filteredRooms);
        roomFilter.filterByDateAvailableFrom(filter.getDateAvailableFrom(), filteredRooms);

        //Hotel's fields
        roomFilter.filterByHotelName(filter.getName(), filteredRooms);
        roomFilter.filterByHotelCountry(filter.getCountry(), filteredRooms);
        roomFilter.filterByHotelCity(filter.getCity(), filteredRooms);
        roomFilter.filterByHotelStreet(filter.getStreet(), filteredRooms);

        return filteredRooms;
    }

    //only admins
    public void addRoom(Room room) throws Exception {
        validateRoom(room);
        roomRepository.save(room);
    }

    //only admins
    public void deleteRoom(long roomId) throws Exception {
        //validate input
        ServiceUtils.validateId(roomId);

        String methodName = "deleteRoom";

        //find a room by id
        Room room = roomRepository.findObjById(roomId);
        if (room == null) {
            throw new BadRequestException(methodName + ": Room (id=" + roomId + ") wasn't found");
        }


        //delete room:
        //if room is used at order - throw new Exception
        for (Order order : orderRepository.getAllObjects()) {
            if (order.getRoom().equals(room)) {
                throw new BadRequestException(methodName + ": can't delete already booked room");
            }
        }

        //if room wasn't used at order - delete it
        roomRepository.remove(room);
    }

    private void validateRoom(Room room) throws BadRequestException {
        String methodName = "validateRoom";
        String msg = "can't be null";
        if (room == null) {
            throw new BadRequestException(methodName + ": Input" + msg);
        }

        if (room.getHotel() == null) {
            throw new BadRequestException(methodName + ": room's hotel" + msg);
        }

        if (room.getDateAvailableFrom() == null) {
            throw new BadRequestException(methodName + ": room's dateAvailableFrom" + msg);
        }

        if (room.getBreakfastIncluded() == null) {
            throw new BadRequestException(methodName + ": room's breakfastIncluded" + msg);
        }

        if (room.getPetsAllowed() == null) {
            throw new BadRequestException(methodName + ": room's petsAllowed" + msg);
        }
    }
}
