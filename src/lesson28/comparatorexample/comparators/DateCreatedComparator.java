package lesson28.comparatorexample.comparators;

import lesson28.comparatorexample.Capability;

import java.util.Comparator;
import java.util.Date;

public class DateCreatedComparator implements Comparator<Capability> {
    @Override
    public int compare(Capability o1, Capability o2) {
        Date o1Date = o1.getDateCreated();
        Date o2Date = o2.getDateCreated();

        if (o1Date.before(o2Date)) {
            return -1;
        } else if (o1Date.equals(o2Date)) {
            return 0;
        } else {
            return 1;
        }
    }
}
