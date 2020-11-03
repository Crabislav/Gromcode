package lesson36.model;

import java.util.Date;

public class Order {
    private Long id;
    private User user;
    private Room room;
    private Date dateFrom;
    private Date dateTo;
    private Double moneyPaid;

    public Order(Long id, User user, Room room, Date dateFrom, Date dateTo, Double moneyPaid) {
        this.id = id;
        this.user = user;
        this.room = room;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.moneyPaid = moneyPaid;
    }

    public Long getId() {
        return id;
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
}
