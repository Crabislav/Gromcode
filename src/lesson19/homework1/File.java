package lesson19.homework1;

public class File {
    private long id;
    private String name;
    private String format;
    private long size;

    public File(String name, String format, long size) throws Exception {
        if (name.length() > 10) {
            throw new Exception(name + "'s length is more than 10");
        } else {
            this.name = name;
            this.format = format;
            this.size = size;

        }
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public String getFormat() {
        return format;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        File file = (File) o;

        if (id != file.id) return false;
        return name.equals(file.name);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        return result;
    }
}
