package gromcode.main.lesson8.home1;

public class Arithmetic {

    public boolean check(int[] array) {
        return (findElement(array, true) + findElement(array, false)) > 100;
    }

    public int findElement(int[] array, boolean isMax) {
        int element = array[0];
        for (int el : array) {
            if (isMax) {
                if (el > element) {
                    element = el;
                }
            } else {
                if (el < element) {
                    element = el;
                }
            }

        }
        return element;
    }
}
