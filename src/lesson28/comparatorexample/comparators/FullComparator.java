package lesson28.comparatorexample.comparators;

import lesson28.comparatorexample.Capability;

import java.util.Comparator;
import java.util.Date;

public class FullComparator implements Comparator<Capability> {
    @Override
    public int compare(Capability o1, Capability o2) {
        //if channelName != - compare using it
        //if channelName = - go to fingerPrint

        //if fingerPrint != - compare using it
        //if fingerPrint = - go to dateCreated

        //if dateCreated != - compare using it
        //if fingerPrint = - return 0

        String o1ChannelName = o1.getChannelName();
        String o2ChannelName = o2.getChannelName();

        if (o1ChannelName == null && o2ChannelName != null) {
            return 1;
        } else if (o1ChannelName != null && o2ChannelName == null) {
            return -1;
        } else if (o1ChannelName == null || o1ChannelName.equals(o2ChannelName)) {
            return fingerprintComparing(o1, o2);
        } else {
            return o1ChannelName.compareTo(o2ChannelName);
        }
    }

    private int fingerprintComparing(Capability o1, Capability o2) {
        String o1Fingerprint = o1.getFingerprint();
        String o2Fingerprint = o2.getFingerprint();

        if (o1Fingerprint == null && o2Fingerprint != null) {
            return 1;
        } else if (o1Fingerprint != null && o2Fingerprint == null) {
            return -1;
        } else if (o1Fingerprint == null || o1Fingerprint.equals(o2Fingerprint)) {
            //Date comparing
            return dateComparing(o1, o2);
        } else {
            return o1Fingerprint.compareTo(o2Fingerprint);
        }
    }

    private int dateComparing(Capability o1, Capability o2) {
        Date o1DateCreated = o1.getDateCreated();
        Date o2DateCreated = o2.getDateCreated();

        if (o2DateCreated == null && o1DateCreated != null) {
            return -1;
        } else if (o2DateCreated != null && o1DateCreated == null) {
            return 1;
        } else if (o2DateCreated == null || o2DateCreated.equals(o1DateCreated)) {
            return 0;
        } else {
            return o2DateCreated.compareTo(o1DateCreated);
        }
    }
}

