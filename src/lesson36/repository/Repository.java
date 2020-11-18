package lesson36.repository;

import lesson36.exceptions.BadRequestException;
import lesson36.model.Entity;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public abstract class Repository<T extends Entity> {
    private String path;

    public T save(T t) throws Exception {
        t.setId(generateId());
        RepositoryUtils.writeToFile(path, new StringBuilder(t.toString()), true);
        return t;
    }

    private Long generateId() throws Exception {
        long id;

        do {
            id = (long) (Math.random() * 50_000_000);
        } while (findObjById(id) != null);

        return id;
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
        StringBuilder content = RepositoryUtils.readFromFile(path);

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}