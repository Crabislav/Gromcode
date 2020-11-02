package gromcode.main.lesson16;

public class StringUsage {
    public static void main(String[] args) {
        String test = "someString";
        String result = test + "_end";

        System.out.println(result);

        //string creation via char[]
        char charVariable = 't';
        char charVariable1 = 'o';

        char[] chars = {charVariable, charVariable1};

        String test1 = new String(chars);
        System.out.println(test1);

        //string creation via keyword "new"
        String test2 = new String("hello there");
        System.out.println(test2);
    }
}
