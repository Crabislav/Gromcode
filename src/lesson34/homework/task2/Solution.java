package lesson34.homework.task2;

import java.io.*;

public class Solution {
    static void transferSentences(String fileFromPath, String fileToPath, String word) throws Exception {
        validate(fileFromPath, fileToPath, word);

        //if fileFrom is empty - we don't need to do anything
        if (isFileEmpty(fileFromPath)) {
            return;
        }

        StringBuffer fileToContent = new StringBuffer();
        StringBuffer fileFromContent = new StringBuffer();

        String[] sentences = readFromFile(fileFromPath).toString().split("\\.");

        for (String sentence : sentences) {
            //finds valid sentences to write
            if (sentence.length() > 10 && sentence.contains(word)) {
                fileToContent.append(sentence).append('.');
            }
            //content without valid sentences
            else if (!sentence.isEmpty()) {
                fileFromContent.append(sentence);
            }
        }

        if (!isFileEmpty(fileToPath)) {
            fileToContent.insert(0, "\n");
        }

        writeToFile(fileToPath, fileToContent, true);
        writeToFile(fileFromPath, fileFromContent, false);
    }

    private static void validate(String fileFromPath, String fileToPath, String word) throws Exception {
        if (word.isEmpty()) {
            throw new Exception("Word can't be empty");
        }

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

    public static StringBuffer readFromFile(String path) {
        StringBuffer res = new StringBuffer();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            //extracting file content
            String line;
            while ((line = br.readLine()) != null) {
                res.append(line);
            }
//            res.replace(res.length() - 1, res.length(), "");
        } catch (FileNotFoundException e) {
            System.err.println("File " + path + "doesn't exists");
        } catch (IOException e) {
            System.err.println("Can't read file from" + path);
        }

        return res;
    }

    public static void writeToFile(String path, StringBuffer contentToWrite, boolean append) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, append))) {
            bw.append(contentToWrite);
        } catch (IOException e) {
            System.err.println("Can't write to file: " + path);
        }
    }

    private static boolean isFileEmpty(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            if (line != null) {
                return false;
            }
        } catch (FileNotFoundException e) {
            System.err.println("File " + path + "doesn't exists");
        } catch (IOException e) {
            System.err.println("Can't read file from" + path);
        }

        return true;
    }
}
