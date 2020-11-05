package lesson36.service;

import lesson36.exceptions.BadRequestException;

public class ServiceUtils {
    static void validateId(long id) throws BadRequestException {
        if (id < 0) {
            throw new BadRequestException("Input must be 0 or greater");
        }
    }
}
