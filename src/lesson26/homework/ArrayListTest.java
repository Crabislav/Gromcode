package lesson26.homework;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListTest {
    public static ArrayList<Order> useList() {
        ArrayList<Order> resultArrayList = new ArrayList<>();

        // add(E e)
        for (int i = 0; i < 3; i++) {
            Order order = new Order(i, i, "currency" + i, "itemName" + i, "shop" + i);
            resultArrayList.add(order);
        }
        System.out.println("add(E e)\n" + resultArrayList);

        // add(int index, E element)
        Order someOrder = new Order(66, 7, "currency", "itemName", "shop");
        resultArrayList.add(2, someOrder);
        System.out.println("\nadd(int index, E element)\n" + resultArrayList);

        // remove(int index)
        resultArrayList.remove(1);
        System.out.println("\nremove(int index)\n" + resultArrayList);

        // remove(Object o)
        resultArrayList.remove(someOrder);
        System.out.println("\nremove(Object o)\n" + resultArrayList);

        // addAll(Collection c)
        ArrayList<Order> list1 = new ArrayList<>();
        for (int i = 45; i < 100; i += 15) {
            Order order = new Order(i, i, "currency" + i, "itemName" + i, "shop" + i);
            list1.add(order);
        }
        resultArrayList.addAll(list1);
        System.out.println("\naddAll(Collection c)\n" + resultArrayList);

        // subList(int fromIndex, int toIndex)
        System.out.println("\nsubList(int fromIndex, int toIndex)\n" + resultArrayList.subList(1, 5));

        // clear()
        System.out.println("\nBefore clear()\n" + resultArrayList);
        resultArrayList.clear();
        System.out.println("\nAfter clear()\n" + resultArrayList);

        for (int i = 0; i < 5; i++) {
            Order order = new Order(i, i, "currency" + i, "itemName" + i, "shop" + i);
            resultArrayList.add(order);
        }

        // set(int index, E element)
        resultArrayList.set(0, someOrder);
        System.out.println("\nset(int index, E element\n" + resultArrayList);

        // boolean contains(Object o)
        System.out.println("\nboolean contains(Object o)\n" + resultArrayList.contains(someOrder));

        // Object[] toArray()
        System.out.println("\nObject[] toArray()\n" + Arrays.toString(resultArrayList.toArray()));

        return resultArrayList;
    }
}
