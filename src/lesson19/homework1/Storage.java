package lesson19.homework1;

public class Storage {

    private long id;
    private File[] files;
    String[] formatsSupported;
    private String storageCountry;
    private long storageSize;

    public Storage(File[] files, String storageCountry, long storageSize) {
        this.files = files;
        this.storageCountry = storageCountry;
        this.storageSize = storageSize;
    }

    public File[] getFiles() {
        return files;
    }

    public void setFiles(File[] files) {
        this.files = files;
    }

    public long getId() {
        return id;
    }

    public long getStorageSize() {
        return storageSize;
    }

    public String[] getFormatsSupported() {
        return formatsSupported;
    }
}
