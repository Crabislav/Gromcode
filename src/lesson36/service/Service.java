package lesson36.service;

import lesson36.exceptions.BadRequestException;

public class Service {
    <T> void validate(T t) throws BadRequestException {
        if (t == null) {
            throw new BadRequestException("validate: Input value can't be null");
        }

        if (t instanceof String && ((String) t).isEmpty()) {
            throw new BadRequestException("validate: User's field can't be empty");
        }
    }
}
