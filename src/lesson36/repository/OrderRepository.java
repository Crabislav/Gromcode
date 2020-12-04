package lesson36.repository;

import lesson36.model.Order;
import lesson36.model.Room;
import lesson36.model.User;

import java.util.Date;

public class OrderRepository extends Repository<Order> {
    private static final UserRepository userRepository = new UserRepository();
    private static final RoomRepository roomRepository = new RoomRepository();

    public OrderRepository() {
        setPath("C:/Users/Alex Kopnin/Desktop/lesson36/OrderDb.txt");
        createRepositoryFile(OrderRepository.class.getSimpleName());
    }

    @Override
    Order getMappedObject(String[] objValues) throws Exception {
        Long id = Long.parseLong(objValues[0]);

        User user = userRepository.findObjById(Long.parseLong(objValues[1]));
        Room room = roomRepository.findObjById(Long.parseLong(objValues[2]));

        Date dateFrom = dateFormat.parse(objValues[3]);
        Date dateTo = dateFormat.parse(objValues[4]);

        Double moneyPaid = Double.parseDouble(objValues[5]);

        return new Order(id, user, room, dateFrom, dateTo, moneyPaid);
    }
}
