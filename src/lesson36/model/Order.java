package lesson36.model;

import java.util.Date;

public class Order extends Entity {
    private Long id;
    private User user;
    private Room room;
    private Date dateFrom;
    private Date dateTo;
    private Double moneyPaid;

    //used for creating
    public Order(User user, Room room, Date dateFrom, Date dateTo, Double moneyPaid) {
        this.user = user;
        this.room = room;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.moneyPaid = moneyPaid;
    }

    //used for mapping
    public Order(Long id, User user, Room room, Date dateFrom, Date dateTo, Double moneyPaid) {
        this.id = id;
        this.user = user;
        this.room = room;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.moneyPaid = moneyPaid;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public Room getRoom() {
        return room;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public Double getMoneyPaid() {
        return moneyPaid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (!id.equals(order.id)) return false;
        if (!user.equals(order.user)) return false;
        if (!room.equals(order.room)) return false;
        if (!dateFrom.equals(order.dateFrom)) return false;
        if (!dateTo.equals(order.dateTo)) return false;
        return moneyPaid.equals(order.moneyPaid);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + user.hashCode();
        result = 31 * result + room.hashCode();
        result = 31 * result + dateFrom.hashCode();
        result = 31 * result + dateTo.hashCode();
        result = 31 * result + moneyPaid.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return id + ", " +
                user + ", " +
                room + ", " +
                dateFrom.toString() + ", " +
                dateTo.toString() + ", " +
                moneyPaid;
    }
}
