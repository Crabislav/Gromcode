package lesson36.repository;

import java.io.*;

public class RepositoryUtils {
    static boolean isFileEmpty(String path) {
        File file = new File(path);
        return file.length() == 0;
    }

    static void writeToFile(String path, StringBuilder content, boolean append) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, append))) {
            if (isFileEmpty(path)) {
                bw.append(content);
            } else {
                bw.append("\n").append(content);
            }
        } catch (IOException e) {
            throw new IOException("writeToFile: Can't write to file: " + path);
        }
    }

    static StringBuilder readFromFile(String path) throws IOException {
        String methodName = "read";
        StringBuilder content = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (isFileEmpty(path)) {
                    return content;
                } else if (!line.isEmpty()) {
                    content.append(line).append("\n");
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(methodName + ": File " + path + "doesn't exists");
        } catch (IOException e) {
            throw new IOException(methodName + ": Can't read file from" + path);
        }
        return content;
    }
}
