package gromcode.main.lesson19.homework1;

public class File {
    private long id;
    private String name;
    private String format;
    private long size;

    public File(int id, String name, String format, long size) throws Exception {
        if (name.length() > 10) {
            throw new Exception(name + "'s length is more than 10");
        } else {
            this.id = id;
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
        return name != null ? name.equals(file.name) : file.name == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", format='" + format + '\'' +
                ", size=" + size +
                '}';
    }
}
