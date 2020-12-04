package lesson36.repository;

import lesson36.model.Order;
import lesson36.model.Room;
import lesson36.model.User;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class OrderRepository extends Repository<Order> {
    private UserRepository userRepository = new UserRepository();
    private RoomRepository roomRepository = new RoomRepository();

    public OrderRepository() {
        setPath("C:/Users/Alex Kopnin/Desktop/lesson36/OrderDb.txt");
        createRepositoryFile(OrderRepository.class.getSimpleName());
    }

    @Override
    Order getMappedObject(String[] objValues) throws Exception {
        Long id = Long.parseLong(objValues[0]);

        User user = userRepository.findObjById(Long.parseLong(objValues[1]));
        Room room = roomRepository.findObjById(Long.parseLong(objValues[2]));

        Date dateFrom = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", new Locale("us"))
                .parse(objValues[3]);
        Date dateTo = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", new Locale("us"))
                .parse(objValues[4]);

        Double moneyPaid = Double.parseDouble(objValues[5]);

        return new Order(id, user, room, dateFrom, dateTo, moneyPaid);
    }

    @Override
    public String getPath() {
        return super.getPath();
    }

    @Override
    public void setPath(String path) {
        super.setPath(path);
    }
}
