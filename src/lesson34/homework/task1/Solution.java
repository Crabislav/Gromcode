package lesson34.homework.task1;

import java.io.*;

public class Solution implements Cloneable {
    static void transferFileContent(String fileFromPath, String fileToPath) throws Exception {
        validate(fileFromPath, fileToPath);

        if (isFileEmpty(fileFromPath)) {
            return;
        }

        if (!isFileEmpty(fileToPath)) {
            writeToFile(fileToPath, readFromFile(fileFromPath).insert(0, "\n"), true);
        } else {
            writeToFile(fileToPath, readFromFile(fileFromPath), true);
        }

        //erasing content from fileFrom
        StringBuffer eraser = new StringBuffer();
        writeToFile(fileFromPath, eraser, false);
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

    public static StringBuffer readFromFile(String path) {
        StringBuffer res = new StringBuffer();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.append(line).append("\n");
            }
            res.replace(res.length() - 1, res.length(), "");
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
}

