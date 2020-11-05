package lesson36.repository;

import lesson36.exceptions.MappingException;
import lesson36.model.Entity;

import java.io.*;
import java.util.ArrayList;

public abstract class Repository<T extends Entity> {
    private String path;

    public T save(T t) throws Exception {
        if (path == null || t == null) {
            throw new IllegalArgumentException("save: Input can't be null");
        }

        //content to write;
        StringBuilder content = new StringBuilder();

        //creates a file if it doesn't exist
        if (!RepositoryUtils.isFileExists(path)) {
            RepositoryUtils.writeToFile(path, content, false);
        }

        //sets valid id to object
        if (RepositoryUtils.isFileEmpty(path)) {
            t.setId(1L);
        } else {
            t.setId(RepositoryUtils.getLastId(path) + 1L);
        }

        //sets proper content to write
        content = new StringBuilder(t.toString());

        RepositoryUtils.writeToFile(path, content, true);
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

    //maps info from file-db to objects
    public ArrayList<T> getAllObjects() throws MappingException, IOException {
        validateGetAllObjects(path);
        //result collection
        return readAndMap(path);
    }

    private void validateGetAllObjects(String path) throws MappingException {
        String methodName = "getAllObjects";

        if (path == null || path.isEmpty()) {
            throw new IllegalArgumentException(methodName + ": path can't be null or empty");
        }

        if (!isFileExists(path)) {
            throw new MappingException(methodName + ": Can't map from nonexistent file " + path);
        }
    }

    private ArrayList<T> readAndMap(String path) throws IOException {
        ArrayList<T> mappedObjects = new ArrayList<>();
        String methodName = "readAndMap";

        //reading from file and mapping
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] objValues = line.split(", ");
                mappedObjects.add(getMappedObject(objValues));
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(methodName + ": File " + path + "doesn't exists");
        } catch (IOException e) {
            throw new IOException(methodName + ": Can't read file from" + path);
        }
        return mappedObjects;
    }

    //each entity has its own amount of fields,
    //so it must be overwritten at each repository class
    abstract T getMappedObject(String[] objValues);

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}