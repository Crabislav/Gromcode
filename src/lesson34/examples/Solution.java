package lesson34.examples;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        String oldFilePath = "C:/Users/Alex Kopnin/Desktop/lib/test.txt";
        String newFilePath = "C:/Users/Alex Kopnin/Desktop/lib/newTest.txt";

        copyFileContent(oldFilePath, newFilePath);
    }

    static void copyFileContent(String fileFromPath, String fileToPath) throws Exception {
        //check file existence +
        //check permissions +
        //read content from fileFrom +
        //write content to fileTo +

        validate(fileFromPath, fileToPath);
        writeToFile(fileToPath, readFromFile(fileFromPath));
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

    private static StringBuffer readFromFile(String path) throws IOException {
        StringBuffer res = new StringBuffer();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.append(line);
            }
            res.replace(res.length() - 1, res.length(), "");
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + path + "doesn't exists");
        } catch (IOException e) {
            throw new IOException("Can't read file from" + path);
        }

        return res;
    }

    private static void writeToFile(String path, StringBuffer contentToWrite) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.append(contentToWrite);
        } catch (IOException e) {
            throw new IOException("Can't write to file: " + path);
        }
    }
}
