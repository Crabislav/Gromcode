package gromcode.main.lesson5;

import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        int[] array = {11, 3, 14, 16, 7};

       // SortArray obj = new SortArray();
        //Before  sorting
        System.out.println("Initial array");
        System.out.println(Arrays.toString(array));

        //After ascending sorting
        System.out.println("\nAfter ascending sorting");
        System.out.println(Arrays.toString(sortAscending(array)));

        //After descending sorting
        System.out.println("\nAfter descending sorting");
        System.out.println(Arrays.toString(sortDescending(array)));
    }

    public static int[] sortAscending(int[] array) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    /*swap(array, i, i + 1);*/
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    isSorted = false;
                }
            }
        }
        return array;
    }

    public static int[] sortDescending(int[] array) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] < array[i + 1]) {
                    //swap(array, i, i + 1);
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    isSorted = false;
                }
            }
        }
        return array;
    }

 /*   public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }*/
}
