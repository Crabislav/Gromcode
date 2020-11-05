package lesson36.repository;

import lesson36.model.Order;

import java.io.IOException;

public class OrderRepository extends Repository<Order> {

    public OrderRepository() throws IOException {
        setPath("C:/Users/Alex Kopnin/Desktop/lesson36/OrderDb.txt");
        RepositoryUtils.createFileIfNotExists(getPath());
    }

    //TODO: finish
    @Override
    Order getMappedObject(String[] objValues) {
        Long id = Long.parseLong(objValues[0]);
//        User user = objValues[1];
//        Room room;
//        Date dateFrom;
//        Date dateTo;
//        Double moneyPaid;
//        return new Order(id, user, room, dateFrom, dateTo, moneyPaid);
        return null;
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
