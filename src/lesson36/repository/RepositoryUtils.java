package lesson36.repository;

import java.io.*;

public class RepositoryUtils {

    @SuppressWarnings("all")
    static boolean isFileExists(String path) {
        File file = new File(path);
        return file.exists();
    }

    static boolean isFileEmpty(String path) {
        File file = new File(path);
        return file.length() == 0;
    }

    static Long getLastId(String path) throws IOException {
        long lastId;
        String lastLine = "";
        String methodName = "getLastId";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                lastLine = currentLine;
            }
            //first field - is always an id field
            String idValue = lastLine.split(", ")[0];
            lastId = Long.parseLong(idValue);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(methodName + ": Can't parse id value from " + lastLine);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(methodName + ": File " + path + "doesn't exists");
        } catch (IOException e) {
            throw new IOException(methodName + ": Can't read file from" + path);
        }

        return lastId;
    }

    static void writeToFile(String path, StringBuilder content, boolean append) throws IOException {
        if (content == null) {
            return;
        }

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
                    return null;
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

    static void createFileIfNotExists(String path) throws IOException {
        if (!RepositoryUtils.isFileExists(path)) {
            RepositoryUtils.writeToFile(path, new StringBuilder(), false);
        }
    }
}
