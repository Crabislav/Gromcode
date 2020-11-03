package lesson36.repository;

import lesson36.model.Entity;

import java.io.*;

public abstract class Repository<T extends Entity> {
    private String path;

    T save(String path, T t) throws Exception {
        if (path == null || t == null) {
            throw new IllegalArgumentException("save: Input (path or t) can't be null");
        }

        //this object contains content to write;
        StringBuffer content = new StringBuffer();

        //creates a file if it doesn't exist
        if (!isFileExists(path)) {
            writeToFile(path, content);
        }

        //sets valid id
        if (isFileEmpty(path)) {
            t.setId(1L);
        } else {
            t.setId(getLastId(path) + 1L);
        }

        //sets proper content to write
        content = new StringBuffer(t.toString());

        writeToFile(path, content);
        return t;
    }

    private void writeToFile(String path, StringBuffer content) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            if (isFileEmpty(path)) {
                bw.append(content);
            }
            //if file isn't empty - it will add a new content from new line
            else {
                bw.append("\n").append(content);
            }
        } catch (IOException e) {
            throw new IOException("writeToFile: Can't write to file: " + path);
        }
    }

    private boolean isFileExists(String path) {
        File file = new File(path);
        return file.exists();
    }

    boolean isFileEmpty(String path) {
        File file = new File(path);
        return file.length() == 0;
    }

    Long getLastId(String path) throws IOException {
        long lastId;
        String lastLine = "";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                lastLine = currentLine;
            }
            //first field - is always an id field
            String idValue = lastLine.split(", ")[0];
            lastId = Long.parseLong(idValue);

        } catch (NumberFormatException e) {
            throw new NumberFormatException("Can't parse id value from " + lastLine);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + path + "doesn't exists");
        } catch (IOException e) {
            throw new IOException("Can't read file from" + path);
        }

        return lastId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}