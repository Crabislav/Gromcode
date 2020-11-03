package lesson36.repository;

import lesson36.model.Entity;

import java.io.*;

public class Repository {
    private String path;

    <T extends Entity> void save(String path, T object) throws Exception {
        checkUpFileExistence(path);

        //sets valid id to object
        if (isFileEmpty(path)) {
            object.setId(1L);
        } else {
            object.setId(getLastId(path) + 1L);
        }

        //this object contains content to write;
        // for example : User info, Room info, etc.
        StringBuffer content = new StringBuffer(object.toString());

        writeToFile(path, content);
    }

    @SuppressWarnings("all")
    private void checkUpFileExistence(String path) {
        File file = new File(path);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                //TODO: change output
                e.printStackTrace();
            }
        }
    }

    boolean isFileEmpty(String path) {
        File file = new File(path);
        return file.length() == 0;
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
            throw new IOException("Can't write to file: " + path);
        }
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