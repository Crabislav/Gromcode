package lesson28.comparatorexample.comparators;

import lesson28.comparatorexample.Capability;

import java.util.Comparator;
import java.util.Date;

public class DateComparator implements Comparator<Capability> {
    @Override
    public int compare(Capability o1, Capability o2) {
        Date o1DateCreated = o1.getDateCreated();
        Date o2DateCreated = o2.getDateCreated();

        if (o1DateCreated == null && o2DateCreated == null) {
            return 0;
        } else if (o2DateCreated == null) {
            return -1;
        } else if (o1DateCreated == null) {
            return 1;
        } else {
            return o2DateCreated.compareTo(o1DateCreated);
        }
    }
}
