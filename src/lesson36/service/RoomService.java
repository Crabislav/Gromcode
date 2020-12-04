package lesson36.service;

import lesson36.exceptions.BadRequestException;
import lesson36.model.Order;
import lesson36.model.Room;
import lesson36.model.filter.Filter;
import lesson36.repository.OrderRepository;
import lesson36.repository.RoomRepository;

import java.util.ArrayList;
import java.util.List;

public class RoomService extends Service {
    private static final RoomRepository roomRepository = new RoomRepository();
    private static final OrderRepository orderRepository = new OrderRepository();

    public List<Room> findRooms(Filter filter) throws Exception {
        List<Room> result = new ArrayList<>();

        for (Room room : roomRepository.getAllObjects()) {
            if (isRoomSuitable(filter, room)) {
                result.add(room);
            }
        }

        return result;
    }

    private boolean isRoomSuitable(Filter filter, Room room) {
        boolean isRoomSuitable = false;

        for (Object roomField : room.getFields()) {
            if (roomField == null) {
                continue;
            }

            isRoomSuitable = compareFieldsWithFilter(filter, isRoomSuitable, roomField);
        }
        return isRoomSuitable;
    }

    private boolean compareFieldsWithFilter(Filter filter, boolean isRoomSuitable, Object roomField) {
        for (Object filterField : filter.getFields()) {
            if (roomField.equals(filterField)) {
                isRoomSuitable = true;
                break;
            }
        }
        return isRoomSuitable;
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
