package lesson34.homework.task1;

public class Demo {
    public static void main(String[] args) {
        String oldFilePath = "C:/Users/Alex Kopnin/Desktop/lib/test.txt";
        String newFilePath = "C:/Users/Alex Kopnin/Desktop/lib/newTest.txt";

        try {

            Solution.transferFileContent(oldFilePath, newFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
