package lesson34.homework.task3;


public class Demo {
    public static void main(String[] args) {
        String oldFilePath = "C:/Users/Alex Kopnin/Desktop/lib/test.txt";
        String newFilePath = "C:/Users/Alex Kopnin/Desktop/lib/newTest.txt";

        try {
            Solution.copyFileContent(oldFilePath, newFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Solution.copyFileContentApacheIO(oldFilePath, newFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
