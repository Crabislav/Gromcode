package gromcode.main.lesson10.homework;

import java.util.Date;

public abstract class Order {
    private String itemName;

    private Date dateCreated;
    private Date dateConfirmed;
    private Date dateShipped;

    private String shipFromCity;
    private String shipToCity;

    private int basePrice;
    private double totalPrice;

    private Customer customerOwned;

    public Order(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned) {
        this.itemName = itemName;
        this.dateCreated = dateCreated;
        this.shipFromCity = shipFromCity;
        this.shipToCity = shipToCity;
        this.basePrice = basePrice;
        this.customerOwned = customerOwned;
    }

    abstract void validateOrder();

    abstract void calculatePrice();

    void confirmShipping() {
        if (dateShipped == null) {
            dateShipped = new Date();
        }
    }

    public String getItemName() {
        return itemName;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Date getDateConfirmed() {
        return dateConfirmed;
    }

    public Date getDateShipped() {
        return dateShipped;
    }

    public String getShipFromCity() {
        return shipFromCity;
    }

    public String getShipToCity() {
        return shipToCity;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Customer getCustomerOwned() {
        return customerOwned;
    }

    public void setDateConfirmed(Date dateConfirmed) {
        this.dateConfirmed = dateConfirmed;
    }

    public void setDateShipped(Date dateShipped) {
        this.dateShipped = dateShipped;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "\n itemName='" + itemName + '\'' +
                ", \n   dateCreated = " + dateCreated +
                ", \n   dateConfirmed = " + dateConfirmed +
                ", \n   dateShipped = " + dateShipped +
                ", \n   shipFromCity = '" + shipFromCity + '\'' +
                ", \n   shipToCity = '" + shipToCity + '\'' +
                ", \n   basePrice = " + basePrice +
                ", \n   totalPrice = " + totalPrice +
                ", \n   customerOwned = " + customerOwned +
                '}' + "\n";
    }
}
