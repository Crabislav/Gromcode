package gromcode.main.lesson28.comparatorexample.comparators;

public class ComparatorUtils {
    public static <T extends Comparable<? super T>> int compareFields(T t1, T t2) {
        if (t1 == null && t2 == null) {
            return 0;
        } else if (t1 == null) {
            return 1;
        } else if (t2 == null) {
            return -1;
        } else {
            return t1.compareTo(t2);
        }
    }
}
