package gromcode.main.lesson18.exercise2;

public class Converter {

    public static void main(String[] args) {
        System.out.println(intToString(111231));
        System.out.println(StringToInt("11"));

        System.out.println(StringToInt("1050a"));

        System.out.println(intToString(-122));
        System.out.println(StringToInt("  "));

        System.out.println(intToString(0));
        System.out.println(StringToInt("\n"));

    }

    public static String intToString(int input) {
        return String.valueOf(input);
    }

    public static int StringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (/*NumberFormatException*/ Exception e) {
            System.out.println(input + " cannot be converted to int");
            return 0;
        }
    }
}
