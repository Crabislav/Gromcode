package gromcode.main.lesson34.homework.task2;


public class Demo {
    public static void main(String[] args) {
        String oldFilePath = "C:/Users/Alex Kopnin/Desktop/lib/test.txt";
        String newFilePath = "C:/Users/Alex Kopnin/Desktop/lib/newTest.txt";

        try {
            Solution.transferSentences(oldFilePath, newFilePath, "test");
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
