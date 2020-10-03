package lesson27.homework1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListTest {
    public static LinkedList<Order> useList() {
        LinkedList<Order> resultLinkedList = new LinkedList<>();

        // add(E e)
        for (int i = 0; i < 3; i++) {
            Order order = new Order(i, i, "currency" + i, "itemName" + i, "shop" + i);
            resultLinkedList.add(order);
        }
        System.out.println("add(E e)\n" + resultLinkedList);

        // add(int index, E element)
        Order someOrder = new Order(66, 7, "currency", "itemName", "shop");
        resultLinkedList.add(2, someOrder);
        System.out.println("\nadd(int index, E element)\n" + resultLinkedList);

        // remove(int index)
        resultLinkedList.remove(1);
        System.out.println("\nremove(int index)\n" + resultLinkedList);

        // remove(Object o)
        resultLinkedList.remove(someOrder);
        System.out.println("\nremove(Object o)\n" + resultLinkedList);

        // addAll(Collection c)
        ArrayList<Order> list1 = new ArrayList<>();
        for (int i = 45; i < 100; i += 15) {
            Order order = new Order(i, i, "currency" + i, "itemName" + i, "shop" + i);
            list1.add(order);
        }
        resultLinkedList.addAll(list1);
        System.out.println("\naddAll(Collection c)\n" + resultLinkedList);

        // subList(int fromIndex, int toIndex)
        System.out.println("\nsubList(int fromIndex, int toIndex)\n" + resultLinkedList.subList(1, 5));

        // clear()
        System.out.println("\nBefore clear()\n" + resultLinkedList);
        resultLinkedList.clear();
        System.out.println("\nAfter clear()\n" + resultLinkedList);

        for (int i = 0; i < 5; i++) {
            Order order = new Order(i, i, "currency" + i, "itemName" + i, "shop" + i);
            resultLinkedList.add(order);
        }

        // set(int index, E element)
        resultLinkedList.set(0, someOrder);
        System.out.println("\nset(int index, E element\n" + resultLinkedList);

        // boolean contains(Object o)
        System.out.println("\nboolean contains(Object o)\n" + resultLinkedList.contains(someOrder));

        // Object[] toArray()
        System.out.println("\nObject[] toArray()\n" + Arrays.toString(resultLinkedList.toArray()));

        return resultLinkedList;
    }
}
