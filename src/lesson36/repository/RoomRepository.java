package lesson36.repository;

import lesson36.model.Room;

import java.io.IOException;


public class RoomRepository extends Repository<Room> {

    public RoomRepository() throws IOException {
        setPath("C:/Users/Alex Kopnin/Desktop/lesson36/RoomDb.txt");
        RepositoryUtils.createFileIfNotExists(getPath());
    }


    /*
    *     private Long id;
    private Integer numberOfGuests;
    private Double price;
    private Boolean breakfastIncluded;
    private Boolean petsAllowed;
    private Date dateAvailableFrom;
    private Hotel hotel;
    * */
    //TODO: finish
    @Override
    Room getMappedObject(String[] objValues) {
        return null;
    }

    @Override
    public String getPath() {
        return super.getPath();
    }

    @Override
    public void setPath(String path) {
        super.setPath(path);
    }
}
