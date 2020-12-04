package lesson36;

import lesson36.model.User;

public class Session {
    private static User authorizedUser;

    private Session() {
    }

    public static User getAuthorizedUser() {
        return authorizedUser;
    }

    public static void setAuthorizedUser(User authorizedUser) {
        Session.authorizedUser = authorizedUser;
    }
}
