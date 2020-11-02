package gromcode.main.lesson19.lessonexamples;

public class ThrowExample {
    private static String[] array = {"test", "test1", "tesrqw", null, "asdaf", "asdad"};

    public static void main(String[] args) {
//        test();

        useOfTestMethod();
    }

    private static void test() throws RuntimeException {
        for (String element : array) {
            if (element == null) {
                throw new RuntimeException("null is detected");
            }
        }

        System.out.println("Done");
    }

    private static void useOfTestMethod() {
        try {
            //some code
            test();
            //some code
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}
