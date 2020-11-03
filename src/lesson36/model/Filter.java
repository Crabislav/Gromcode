package lesson36.model;

import java.util.Date;

public class Filter {
    //Room fields
    private Integer numberOfGuests;
    private Double price;
    private Boolean breakfastIncluded;
    private Boolean petsAllowed;
    private Date dateAvailableFrom;

    //Hotel fields
    private String name;
    private String country;
    private String city;
    //not necessary
//    private String street;


    public Filter(Integer numberOfGuests, Double price, Boolean breakfastIncluded, Boolean petsAllowed, Date dateAvailableFrom, String name, String country, String city) {
        this.numberOfGuests = numberOfGuests;
        this.price = price;
        this.breakfastIncluded = breakfastIncluded;
        this.petsAllowed = petsAllowed;
        this.dateAvailableFrom = dateAvailableFrom;
        this.name = name;
        this.country = country;
        this.city = city;
    }
}
