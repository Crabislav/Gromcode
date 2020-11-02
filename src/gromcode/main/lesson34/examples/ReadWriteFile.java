package gromcode.main.lesson34.examples;

import java.io.*;

public class ReadWriteFile {
    public static void main(String[] args) {
        readFile("C:/Users/Alex Kopnin/Desktop/lib/test.txt");
        writeFile("C:/Users/Alex Kopnin/Desktop/lib/test1.txt", "text");
    }


    //old
//    private static void readFile(String path) {
//        FileReader reader;
//        try {
//            reader = new FileReader(path);
//        } catch (FileNotFoundException e) {
//            System.err.println("File does not exists");
//            return;
//        }
//        BufferedReader br = new BufferedReader(reader);
//
//        try {
//            String line;
//            while ((line = br.readLine()) != null) {
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//            System.err.println("Reading from file" + path + " failed");
//        } finally {
//            IOUtils.closeQuietly(br);
//            IOUtils.closeQuietly(reader);
//        }
//    }

    private static void readFile(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File does not exists");
        } catch (IOException e) {
            System.err.println("Reading from file" + path + " failed");
        }
    }

    private static void writeFile(String path, String content) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            bufferedWriter.append(content);
        } catch (IOException e) {
            System.err.println("Can't write to file");
        }
    }
}
