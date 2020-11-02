package gromcode.main.lesson28.comparatorexample.comparators;

import gromcode.main.lesson28.comparatorexample.Capability;

import java.util.Comparator;

public class DateComparator implements Comparator<Capability> {
    @Override
    public int compare(Capability o1, Capability o2) {
        return ComparatorUtils.compareFields(o2.getDateCreated(), o1.getDateCreated());
    }
}
