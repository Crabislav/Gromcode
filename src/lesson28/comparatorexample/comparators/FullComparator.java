package lesson28.comparatorexample.comparators;

import lesson28.comparatorexample.Capability;

import java.util.Comparator;

public class FullComparator implements Comparator<Capability> {
    @Override
    public int compare(Capability o1, Capability o2) {
        //if channelName != - compare using it
        //if channelName = - go to fingerPrint

        //if fingerPrint != - compare using it
        //if fingerPrint = - go to dateCreated

        //if dateCreated != - compare using it
        //if fingerPrint = - return 0

        int comparingResult = ComparatorUtils.compareFields(o1.getChannelName(), o2.getChannelName());

        if (comparingResult == 0) {
            comparingResult = ComparatorUtils.compareFields(o1.getFingerprint(), o2.getFingerprint());

            if (comparingResult == 0) {
                comparingResult = ComparatorUtils.compareFields(o2.getDateCreated(), o1.getDateCreated());
            }
        }
        return comparingResult;
    }
}

