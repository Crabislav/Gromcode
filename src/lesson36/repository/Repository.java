package lesson36.repository;

import lesson36.exceptions.BadRequestException;
import lesson36.exceptions.EmptyRepositoryException;
import lesson36.model.Entity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public abstract class Repository<T extends Entity> {
    private String path;

    public T save(T t) throws IOException, BadRequestException {
        if (t == null) {
            throw new BadRequestException("save: input can't be null");
        }

        if (path == null) {
            throw new BadRequestException("save: path can't be null");
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
        RepositoryUtils.writeToFile(path, content, false);
    }

    //maps info from file-db to objects
    public ArrayList<T> getAllObjects() throws Exception {
        String methodName = "getAllObjects";

        if (!RepositoryUtils.isFileExists(path)) {
            throw new FileNotFoundException(methodName + ": Can't map from non-existent file " + path);
        }

        StringBuilder content = RepositoryUtils.readFromFile(path);

        if (content.toString().isEmpty()) {
            throw new EmptyRepositoryException(methodName + ": Can't get object values from empty repository");
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}