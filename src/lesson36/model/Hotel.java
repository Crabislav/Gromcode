package lesson36.model;

public class Hotel extends Entity {
    private Long id;
    private String name;
    private String country;
    private String city;
    private String street;

    private Hotel(String name, String country, String city, String street) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.street = street;
    }

    //TODO: probably do refactor
    public static Hotel newInstance(String name, String country, String city, String street) {
//        Entity.checkArgument(!name.isEmpty());
//        Entity.checkArgument(!country.isEmpty());
//        Entity.checkArgument(!city.isEmpty());
//        Entity.checkArgument(!street.isEmpty());

        return new Hotel(name, country, city, street);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public String toString() {
        return id.toString();
    }
}
