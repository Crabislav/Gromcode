package lesson34.homework.task1;

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        String oldFilePath = "C:/Users/Alex Kopnin/Desktop/lib/test.txt";
        String newFilePath = "C:/Users/Alex Kopnin/Desktop/lib/newTest.txt";

        transferFileContent(oldFilePath, newFilePath);
    }

    static void transferFileContent(String fileFromPath, String fileToPath) throws Exception {
        validate(fileFromPath, fileToPath);
        writeToFile(fileToPath, readFromFile(fileFromPath), true);
    }

    private static void validate(String fileFromPath, String fileToPath) throws Exception {
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        if (!fileFrom.exists()) {
            throw new FileNotFoundException("File " + fileFrom + "doesn't exist");
        }

        if (!fileTo.exists()) {
            throw new FileNotFoundException("File " + fileTo + "doesn't exist");
        }

        if (!fileFrom.canRead()) {
            throw new Exception("File " + fileFrom + " doesn't have permission to be read");
        }

        if (!fileTo.canWrite()) {
            throw new Exception("File " + fileTo + " doesn't have permission to be written");
        }
    }

    private static String readFromFile(String path) {
        StringBuilder fileContent = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            //saving a file's content
            String line;
            while ((line = br.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
            fileContent.replace(fileContent.length() - 1, fileContent.length(), "");

            //erasing
            writeToFile(path, "", false);
        } catch (FileNotFoundException e) {
            System.err.println("File " + path + "doesn't exists");
        } catch (IOException e) {
            System.err.println("Can't read file from" + path);
        }

        return fileContent.toString();
    }

    private static void writeToFile(String path, String contentToWrite, boolean append) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, append))) {
            bw.append(contentToWrite);
        } catch (IOException e) {
            System.err.println("Can't write to file: " + path);
        }
    }

}

