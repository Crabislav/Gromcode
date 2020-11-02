package gromcode.main.lesson31.homework;

public class Demo {
    public static void main(String[] args) {
        String[] words = {"asdd dd", "he he", "Hello hello", "aaa aaa bbb ccc", "abaca"};

        for (String word : words) {
            System.out.println(word);
            try {
                System.out.println(Solution.countSymbols(word));
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                System.out.println(Solution.words(word)+"\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
