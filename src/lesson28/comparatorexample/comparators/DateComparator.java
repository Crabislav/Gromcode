package lesson28.comparatorexample.comparators;

import lesson28.comparatorexample.Capability;

import java.util.Comparator;
import java.util.Date;

public class DateComparator implements Comparator<Capability> {
    @Override
    public int compare(Capability o1, Capability o2) {
        return o2.getDateCreated().compareTo(o1.getDateCreated());
    }
}
