package lesson33.homework.task2;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class Solution {
    static void readFileByConsolePath() {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String path = "";
        path = getPathFromConsoleInput(inputStreamReader, bufferedReader, path);

        //Reading a file
        readFile(path);

    }

    private static String getPathFromConsoleInput(InputStreamReader isr, BufferedReader br, String path) {
        System.out.println("Please, enter file path to read: ");
        try {
            path = br.readLine();
        } catch (IOException e) {
            System.err.println("Reading from keyboard was failed");
        } finally {
            IOUtils.closeQuietly(isr);
            IOUtils.closeQuietly(br);
        }
        return path;
    }

    private static void readFile(String path) {
        FileReader reader;
        try {
            reader = new FileReader(path);
        } catch (FileNotFoundException e) {
            System.err.println("File with path" + path + "not found");
            return;
        }
        BufferedReader br = new BufferedReader(reader);

        try {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Can't read file by path " + path);
        } finally {
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(reader);
        }
    }
}
