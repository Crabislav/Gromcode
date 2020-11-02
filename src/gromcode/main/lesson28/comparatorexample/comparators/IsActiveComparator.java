package gromcode.main.lesson28.comparatorexample.comparators;


import gromcode.main.lesson28.comparatorexample.Capability;

import java.util.Comparator;

public class IsActiveComparator implements Comparator<Capability> {

    @Override
    public int compare(Capability o1, Capability o2) {
//        System.out.println("IsActiveComparator is used");
        boolean o1IsActive = o1.isActive();
        boolean o2IsActive = o2.isActive();

        if (o1IsActive && !o2IsActive) {
            return -1;
        } else if ((o1IsActive && o2IsActive) || (!o1IsActive && !o2IsActive)) {
            return 0;
        } else {
            return 1;
        }
    }
}
