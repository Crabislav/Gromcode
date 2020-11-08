package lesson36.model.filter;

import java.util.Date;

public class FilterBuilder {
    private Integer numberOfGuests;
    private Double price;
    private Boolean breakfastIncluded;
    private Boolean petsAllowed;
    private Date dateAvailableFrom;
    private String name;
    private String country;
    private String city;
    private String street;

    public FilterBuilder setNumberOfGuests(Integer numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
        return this;
    }

    public FilterBuilder setPrice(Double price) {
        this.price = price;
        return this;
    }

    public FilterBuilder setBreakfastIncluded(Boolean breakfastIncluded) {
        this.breakfastIncluded = breakfastIncluded;
        return this;
    }

    public FilterBuilder setPetsAllowed(Boolean petsAllowed) {
        this.petsAllowed = petsAllowed;
        return this;
    }

    public FilterBuilder setDateAvailableFrom(Date dateAvailableFrom) {
        this.dateAvailableFrom = dateAvailableFrom;
        return this;
    }

    public FilterBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public FilterBuilder setCountry(String country) {
        this.country = country;
        return this;
    }

    public FilterBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public FilterBuilder setStreet(String street) {
        this.street = street;
        return this;
    }

    public Filter createFilter() {
        return new Filter(numberOfGuests, price, breakfastIncluded, petsAllowed, dateAvailableFrom, name, country, city, street);
    }
}