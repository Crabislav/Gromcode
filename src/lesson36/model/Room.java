package lesson36.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Room extends Entity {
    private Long id;
    private Integer numberOfGuests;
    private Double price;
    private Boolean breakfastIncluded;
    private Boolean petsAllowed;
    private Date dateAvailableFrom;
    private Hotel hotel;

    public Room(Integer numberOfGuests, Double price, Boolean breakfastIncluded, Boolean petsAllowed, Date dateAvailableFrom, Hotel hotel) {
        this.numberOfGuests = numberOfGuests;
        this.price = price;
        this.breakfastIncluded = breakfastIncluded;
        this.petsAllowed = petsAllowed;
        this.dateAvailableFrom = dateAvailableFrom;
        this.hotel = hotel;
    }

    public Room(Long id, Integer numberOfGuests, Double price, Boolean breakfastIncluded, Boolean petsAllowed, Date dateAvailableFrom, Hotel hotel) {
        this.id = id;
        this.numberOfGuests = numberOfGuests;
        this.price = price;
        this.breakfastIncluded = breakfastIncluded;
        this.petsAllowed = petsAllowed;
        this.dateAvailableFrom = dateAvailableFrom;
        this.hotel = hotel;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumberOfGuests() {
        return numberOfGuests;
    }

    public Double getPrice() {
        return price;
    }

    public Boolean getBreakfastIncluded() {
        return breakfastIncluded;
    }

    public Boolean getPetsAllowed() {
        return petsAllowed;
    }

    public Date getDateAvailableFrom() {
        return dateAvailableFrom;
    }

    public void setDateAvailableFrom(Date dateAvailableFrom) {
        this.dateAvailableFrom = dateAvailableFrom;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public List<Object> getFields() {
        return Arrays.asList(getBreakfastIncluded(), getDateAvailableFrom(), getNumberOfGuests(),
                getPetsAllowed(), getPrice(), getHotel().getCity(), getHotel().getCountry(),
                getHotel().getName(), getHotel().getStreet());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (!numberOfGuests.equals(room.numberOfGuests)) return false;
        if (!price.equals(room.price)) return false;
        if (!breakfastIncluded.equals(room.breakfastIncluded)) return false;
        if (!petsAllowed.equals(room.petsAllowed)) return false;
        if (!dateAvailableFrom.equals(room.dateAvailableFrom)) return false;
        return hotel.equals(room.hotel);
    }

    @Override
    public int hashCode() {
        int result = numberOfGuests.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + breakfastIncluded.hashCode();
        result = 31 * result + petsAllowed.hashCode();
        result = 31 * result + dateAvailableFrom.hashCode();
        result = 31 * result + hotel.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return id + ", " +
                numberOfGuests + ", " +
                price + ", " +
                breakfastIncluded + ", " +
                petsAllowed + ", " +
                dateAvailableFrom + ", " +
                hotel.getId();
    }
}
