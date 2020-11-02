package gromcode.main.lesson25.homework;

import gromcode.main.lesson22.homework.exception.InternalServerException;
import gromcode.main.lesson25.homework.entities.Product;
import gromcode.main.lesson25.homework.exceptions.BadRequestException;

import java.lang.reflect.Array;


public class GeneralDAO<T extends Product> {
    private T[] array;

    @SuppressWarnings("unchecked")
    public GeneralDAO(Class<T> instance) {
        array = (T[]) Array.newInstance(instance, 10);
    }

    public T save(T t) throws Exception {
        validate(t);

        int index = 0;
        for (T el : array) {
            if (el == null) {
                array[index] = t;
                return array[index];
            }
            index++;
        }

        //не хватает места в массиве (заполнен) +
        throw new InternalServerException("No space for saving object (id=" + t.getId() + ")");
    }

    private void validate(T t) throws BadRequestException {
        //сохранение null +
        if (t == null) {
            throw new BadRequestException("Can't save null");
        }

        //сохранение одного и того же объекта  +
        for (T el : array) {
            if (el != null && el.equals(t)) {
                throw new BadRequestException("Can't save already existing object (id=" + t.getId() + ")");
            }
        }
    }

    public T[] getAll() {
        return array;
    }

}


