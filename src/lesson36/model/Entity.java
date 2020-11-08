package lesson36.model;

public abstract class Entity {
    public abstract Long getId();

    public abstract void setId(Long id);

    public abstract boolean equals(Object o);

    public abstract int hashCode();
}
