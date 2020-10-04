package lesson28.comparatorexample;

import lesson28.comparatorexample.comparators.DateComparator;
import lesson28.comparatorexample.comparators.IsActiveComparator;
import lesson28.comparatorexample.comparators.FullComparator;

import java.util.*;

public class DemoComparator {
    public static void main(String[] args) {
        ArrayList<Capability> capabilities = initCapabilities();

        System.out.println("Before IsActiveComparator\n" + capabilities);
        capabilities.sort(new IsActiveComparator());
        System.out.println("After IsActiveComparator\n" + capabilities);

        System.out.println("\nBefore DateComparator\n" + capabilities);
        capabilities.sort(new DateComparator());
        System.out.println("After DateComparator\n" + capabilities);

        System.out.println("\nBefore FullComparator\n" + capabilities);
        capabilities.sort(new FullComparator());
        System.out.println("After FullComparator\n" + capabilities);

    }

    private static ArrayList<Capability> initCapabilities() {
        Capability capability1 = new Capability(1001, "test3", "rrrr", false, new Date());
        Capability capability2 = new Capability(1005, "test2", "rrdrr", true, new Date());
        Capability capability3 = new Capability(9800, "test0", "rrraar", false, new Date());
        Capability capability4 = new Capability(900, "test1", "rrr1r", true, new Date());

        ArrayList<Capability> capabilities = new ArrayList<>();
        capabilities.add(capability1);
        capabilities.add(capability2);
        capabilities.add(capability3);
        capabilities.add(capability4);

        return capabilities;
    }
}
