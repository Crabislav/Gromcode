package gromcode.main.lesson33.homework.task2;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class Solution {
    static void readFileByConsolePath() {
        readFile(getPathFromConsole());
    }

    private static String getPathFromConsole() {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String path = null;
        System.out.println("Please, enter file path to read: ");

        try {
            path = bufferedReader.readLine();
        } catch (IOException e) {
            System.err.println("Reading from keyboard was failed");
        } finally {
            IOUtils.closeQuietly(inputStreamReader);
            IOUtils.closeQuietly(bufferedReader);
        }
        return path;
    }

    private static void readFile(String path) {
        FileReader reader;
        try {
            reader = new FileReader(path);
        } catch (FileNotFoundException e) {
            System.err.println("File with path " + path + " not found");
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
