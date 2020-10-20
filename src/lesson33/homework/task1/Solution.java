package lesson33.homework.task1;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class Solution {
    static void writeToFileFromConsole(String path) {
        writingToFile(path);
    }

    private static String getInputFromConsole() {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String userInput = "";
        StringBuilder result = new StringBuilder();
        String writeCommand = "wr";

        try {
            while (!userInput.equals(writeCommand)) {
                System.out.println("Enter file content to write in the file: ");

                userInput = bufferedReader.readLine();
                result.append("\n").append(userInput);
            }
        } catch (IOException e) {
            System.err.println("Reading from keyboard was failed");
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(bufferedReader);
        }

        return result.toString();
    }

    private static void writingToFile(String path) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try {
            fileWriter = new FileWriter(path, true);
            bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(getInputFromConsole());
        } catch (FileNotFoundException e) {
            System.err.println("File with path " + path + " not found");
        } catch (IOException e1) {
            System.err.println("Can't write to file with path " + path);
        } finally {
            IOUtils.closeQuietly(bufferedWriter);
            IOUtils.closeQuietly(fileWriter);
        }
    }
}

