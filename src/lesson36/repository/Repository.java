package lesson36.repository;

import lesson36.exceptions.BadRequestException;
import lesson36.model.Entity;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

public abstract class Repository<T extends Entity> {
    private String path;

    static final SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy",
            new Locale("us"));

    public T save(T t) throws Exception {
        long id = (long) (Math.random() * 50_000_000);
        t.setId(id);
        writeToFile(path, new StringBuilder(t.toString()), true);
        return t;
    }

    public void remove(T t) throws Exception {
        List<T> allObjects = getAllObjects();
        if (!allObjects.contains(t)) {
            throw new BadRequestException("remove: Input object wasn't found");
        }
        allObjects.remove(t);

        StringBuilder content = new StringBuilder();
        for (T object : allObjects) {
            if (allObjects.indexOf(object) == (allObjects.size() - 1)) {
                content.append(object.toString());
                break;
            }
            content.append(object.toString()).append("\n");
        }
        writeToFile(path, content, false);
    }

    public List<T> getAllObjects() throws Exception {
        StringBuilder content = readFromFile(path);

        if (content.length() == 0) {
            return new ArrayList<>();
        }

        ArrayList<T> mappedObjects = new ArrayList<>();

        String[] objects = Pattern.compile("\n").split(content);
        for (String object : objects) {
            String[] objValues = object.split(", ");
            mappedObjects.add(getMappedObject(objValues));
        }

        return mappedObjects;
    }

    abstract T getMappedObject(String[] objValues) throws Exception;

    public T findObjById(long id) throws Exception {
        List<T> allObjects = getAllObjects();
        for (T obj : allObjects) {
            if (obj.getId() == id) {
                return obj;
            }
        }
        return null;
    }

    private void writeToFile(String path, StringBuilder content, boolean append) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, append))) {
            if (isFileEmpty()) {
                bw.append(content);
            } else {
                bw.append("\n").append(content);
            }
        } catch (IOException e) {
            throw new IOException("writeToFile: Can't write to file: " + path);
        }
    }

    private StringBuilder readFromFile(String path) throws IOException {
        String methodName = "read";
        StringBuilder content = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (isFileEmpty()) {
                    return content;
                } else if (!line.isEmpty()) {
                    content.append(line).append("\n");
                }
            }
        } catch (IOException e) {
            throw new IOException(methodName + ": Can't read file from" + path);
        }
        return content;
    }

    void createRepositoryFile(String className) {
        try {
            if (!new File(getPath()).createNewFile()) {
                System.out.println(className + " already exists. File wasn't created");
            }
        } catch (IOException e) {
            System.out.println("Can't create" + className + " file");
        }
    }

    private boolean isFileEmpty() {
        File file = new File(path);
        return file.length() == 0;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}