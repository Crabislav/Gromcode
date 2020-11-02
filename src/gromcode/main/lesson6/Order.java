package gromcode.main.lesson6;

import java.util.Date;

public class Order {
    long id;
    int price;
    Date dateCreated;
    boolean isConfirmed;
    Date dateConfirmed;
    String city;
    String country;
    String type;

    public Order() {
    }

    public Order(int price, Date dateCreated, boolean isConfirmed, Date dateConfirmed, String city, String country, String type) {
        this.price = price;
        this.dateCreated = dateCreated;
        this.isConfirmed = isConfirmed;
        this.dateConfirmed = dateConfirmed;
        this.city = city;
        this.country = country;
        this.type = type;
    }

    public void confirmOrder() {
        // if (dateConfirmed == null)
        //  dateConfirmed = new Date();
        if (!isConfirmed) {
            dateConfirmed = new Date();
            isConfirmed = true;
        }
    }

    public boolean checkPrice() {
        return price > 1000;
    }

    public boolean isValidType() {
        return type.equals("Buy") || type.equals("Sale");
    }
}
