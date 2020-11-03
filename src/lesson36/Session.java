package lesson36;

//Represents a simple login system

import lesson36.model.User;

public class Session {
    private static User signedInUser;

    public static User getSignedInUser() {
        return signedInUser;
    }

    public static void setSignedInUser(User signedInUser) {
        Session.signedInUser = signedInUser;
    }
}
