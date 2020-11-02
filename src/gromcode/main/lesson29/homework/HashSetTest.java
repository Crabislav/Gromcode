package gromcode.main.lesson29.homework;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {
    public static Set<Order> useHashSet() {
        Set<Order> orders = new HashSet<>();

        //add(E e)
        System.out.println("\nBefore add(E e)\n" + orders);
        fillSet(orders, 5);
        System.out.println("\nAfter add(E e)\n" + orders);

        removeShowcase(orders);
        iteratorShowcase(orders);
        retainAllShowcase(orders);

        //Object[] toArray()
        System.out.println("\nObject[] toArray()\n" + Arrays.toString(orders.toArray()));

        //size()
        System.out.println("\nOrders size is " + orders.size());

        orders.clear();
        fillSet(orders, 5);
        return orders;
    }

    private static void iteratorShowcase(Set<Order> orders) {
        System.out.println("Iterator usage");
        Iterator<Order> orderIterator = orders.iterator();
        while (orderIterator.hasNext()) {
            System.out.println(orderIterator.next().getItemName());
        }
    }

    private static void removeShowcase(Set<Order> orders) {
        Order order = new Order(9, 233, "USD", "noItemName", "asdasd");
        orders.add(order);

        System.out.println("\nBefore remove(E e)\n" + orders);
        orders.remove(order);
        System.out.println("\nAfter remove(E e)\n" + orders);
    }

    private static void retainAllShowcase(Set<Order> orders) {
        orders.clear();
        fillSet(orders, 3);

        Set<Order> orders1 = new HashSet<>();
        fillSet(orders1, 1);

        System.out.println("\nBefore retainAll\n" + "Orders\n" + orders + "\n" + "\nOrders1\n" + orders1);
        orders.retainAll(orders1);
        System.out.println("\nAfter retainAll\n" + "Orders\n" + orders + "\n" + "\nOrders1\n" + orders1);
    }

    private static void fillSet(Set<Order> orders, int amount) {
        if (amount > 0) {
            for (int i = 0; i < amount; i++) {
                Order order = new Order(i, 100 + i * 10, "currency" + i, "name" + i, "" + i);
                orders.add(order);
            }
        }
    }
}


