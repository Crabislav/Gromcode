package gromcode.main.lesson6;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Order order = new Order();


        System.out.println(order.isConfirmed);
        System.out.println(order.dateConfirmed);
        System.out.println();

        order.dateConfirmed = new Date();

        order.confirmOrder();
        System.out.println(order.isConfirmed);
        System.out.println(order.dateConfirmed);
    }
}
