package lesson8.home1;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        Adder adder = new Adder();

        int[] array = {10, 23, 2, 45, -2, 6, 103};

        System.out.println("Initial array\n" + Arrays.toString(array) + "\n");
//        System.out.println("Max element : " + adder.findElement(array, true));
//        System.out.println("Min element : " + adder.findElement(array, false));
        System.out.println("Check method result : " + adder.check(array));
        System.out.println("Add method result : " + adder.add(1,3));

    }

}
