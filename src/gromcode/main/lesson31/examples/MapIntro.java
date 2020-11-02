package gromcode.main.lesson31.examples;

import java.util.HashMap;
import java.util.Map;

public class MapIntro {
    public static void main(String[] args) {
        Map<String, Building> map = new HashMap<>();

        Building building = new Building("school", 5);
        Building building1 = new Building("house", 9);

        map.put("21tadd", building);
        map.put("asdasd", building1);
        System.out.println(map);

        System.out.println(map.keySet());

        System.out.println(map.values());

        System.out.println(map.get("asdassss"));

        map.remove("21tadd");

        System.out.println(map);

//        map.put(null, building);

        map.put("asdasd", building1);
    }
}
