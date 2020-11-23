package lesson36.repository;

import lesson36.exceptions.BadRequestException;
import lesson36.model.Entity;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public abstract class Repository<T extends Entity> {
    private String path;

    public T save(T t) throws Exception {
        long id = (long) (Math.random() * 50_000_000);
        t.setId(id);
        writeToFile(path, new StringBuilder(t.toString()), true);
        return t;
    }

    public void remove(T t) throws Exception {
        //find an object at repository
        ArrayList<T> allObjects = getAllObjects();
        if (!allObjects.contains(t)) {
            throw new BadRequestException("remove: Input object wasn't found");
        }

        //delete it
        allObjects.remove(t);

        //rewrite repos file
        StringBuilder content = new StringBuilder();
        for (T object : allObjects) {
            //appends last object without new line
            if (allObjects.indexOf(object) == (allObjects.size() - 1)) {
                content.append(object.toString());
                break;
            }
            content.append(object.toString()).append("\n");
        }
        writeToFile(path, content, false);
    }

    //maps info from file-db to objects
    public ArrayList<T> getAllObjects() throws Exception {
        StringBuilder content = readFromFile(path);

        if (content.length() == 0) {
            return new ArrayList<>();
        }
        //result array
        ArrayList<T> mappedObjects = new ArrayList<>();

        //filling result array with mapped objects
        String[] objects = Pattern.compile("\n").split(content);
        for (String object : objects) {
            String[] objValues = object.split(", ");
            mappedObjects.add(getMappedObject(objValues));
        }

        return mappedObjects;
    }

    //each entity has its own amount of fields,
    //so it must be overwritten at each repository class
    abstract T getMappedObject(String[] objValues) throws Exception;

    public T findObjById(long id) throws Exception {
        ArrayList<T> allObjects = getAllObjects();
        for (T obj : allObjects) {
            if (obj.getId() == id) {
                return obj;
            }
        }
        return null;
    }

    private static boolean isFileEmpty(String path) {
        File file = new File(path);
        return file.length() == 0;
    }

    private static void writeToFile(String path, StringBuilder content, boolean append) throws IOException {
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

    private static StringBuilder readFromFile(String path) throws IOException {
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}