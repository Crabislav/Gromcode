package lesson36.model;

import lesson36.model.enums.UserType;

public class User extends Entity {
    private Long id;
    private String userName;
    private String password;
    private String country;
    private UserType userType;

    private User(String userName, String password, String country, UserType userType) {
        this.userName = userName;
        this.password = password;
        this.country = country;
        this.userType = userType;
    }

    //used for mapping
    public User(Long id, String userName, String password, String country, UserType userType) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.country = country;
        this.userType = userType;
    }

    //TODO: probably do refactor
    public static User newInstance(String userName, String password, String country, UserType userType) {
        return new User(userName, password, country, userType);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getCountry() {
        return country;
    }

    public UserType getUserType() {
        return userType;
    }

    @Override
    public String toString() {
        return id + ", " +
                userName + ", " +
                password + ", " +
                country + ", " +
                userType;
    }
}
