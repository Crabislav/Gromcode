package lesson36.controller;

import lesson36.Session;
import lesson36.exceptions.AuthorizationException;
import lesson36.exceptions.NotEnoughRightsException;
import lesson36.model.enums.UserType;

public abstract class Controller {
    static void checkUserRights() throws NotEnoughRightsException {
        if (Session.getAuthorizedUser().getUserType() == UserType.USER) {
            throw new NotEnoughRightsException("User (id=" + Session.getAuthorizedUser().getId() +
                    " ,name=" + Session.getAuthorizedUser().getUserName() + ") doesn't have enough rights");
        }
    }

    static void checkIsUserAuthorized(String methodName) throws AuthorizationException {
        if (Session.getAuthorizedUser() == null) {
            throw new AuthorizationException("Can't execute " + methodName + " method without user login");
        }
    }
}
