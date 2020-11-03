package lesson36;

//Represents a simple login system

import lesson36.model.User;

public class Session {
    private static User authorizedUser;


    public static User getAuthorizedUser() {
        return authorizedUser;
    }

    public static void setAuthorizedUser(User authorizedUser) {
        Session.authorizedUser = authorizedUser;
    }
}
