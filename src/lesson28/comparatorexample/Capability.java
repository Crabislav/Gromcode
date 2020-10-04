package lesson28.comparatorexample;

import java.util.Date;

public class Capability implements Comparable<Capability> {
    //id : 1001, 1005, 900 - must be 900, 1001, 1005 - default sorting
    private long id;
    private String channelName;
    private String fingerprint;
    private boolean isActive;
    private Date dateCreated;

    public Capability(long id, String channelName, String fingerprint, boolean isActive, Date dateCreated) {
        this.id = id;
        this.channelName = channelName;
        this.fingerprint = fingerprint;
        this.isActive = isActive;
        this.dateCreated = dateCreated;
    }

    public long getId() {
        return id;
    }

    public String getChannelName() {
        return channelName;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public boolean isActive() {
        return isActive;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    //-1 or 0 or 1
    @Override
    public int compareTo(Capability capability) {
        System.out.println("compare to is used");
        return (int) (this.id - capability.getId());

        //before : 1001, 1005, 900
        //step 1 : 1001 - 1005 = -4
        //after : 1001, 1005, 900

        //before : 1001, 1005, 900
        //step 2 : 1005 - 900 = 105
        //after : 1001, 900, 1005

        //before : 1001, 900, 1005
        //step 2 : 1001 - 900 = 101
        //after : 900, 1001, 1005
    }

    @Override
    public String toString() {
        return "\nCapability{" +
                "id=" + id +
                ", channelName='" + channelName + '\'' +
                ", fingerprint='" + fingerprint + '\'' +
                ", isActive=" + isActive +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
