package lesson4;

public class Concat {
    public static void main(String[] args) {
        //System.out.println(concat("Gr", "om", "code"));
        System.out.println(concat("Unknown ", null, "ror"));
        System.out.println(concat("1", null, null));

    }

    public static String concat(String a, String b, String c) {
        // return stringNullCheck(a) + stringNullCheck(b) + stringNullCheck(c);
        return isNull(a).concat(isNull(b)).concat(isNull(c));
    }

    public static String isNull(String string) {
        return string == null ? "null" : string;
    }
}


