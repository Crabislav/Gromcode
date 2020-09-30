package lesson25.homework;

import lesson25.homework.entities.Book;
import lesson25.homework.entities.Magazine;
import lesson25.homework.entities.Newspaper;
import lesson25.homework.entities.Product;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        GeneralDAO<Product> productDAO = new GeneralDAO<>(Product.class);

        Product book = new Book(0, "book");
        Product magazine = new Magazine(1, "magazine");
        Product newsPaper = new Newspaper(3, "newspaper");
        Product badIdNewsPaper = new Newspaper(3, "newspaper");

        Product[] products = {book, magazine, newsPaper, badIdNewsPaper};

        for (Product element : products) {
            try {
                productDAO.save(element);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

        System.out.println(Arrays.deepToString(productDAO.getAll()));
    }
}
