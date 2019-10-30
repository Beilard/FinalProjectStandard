package ua.delivery.model.domain;


import java.io.Serializable;
import java.util.Objects;


public class Package implements Serializable {
    private static final long serialversionUID = 3L;
    private final Long id;
    private final String type;
    private final Double weight;

    public Package(Long id, String type, Double weight) {
        this.id = id;
        this.type = type;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Package aPackage = (Package) o;
        return getType().equals(aPackage.getType()) &&
                getWeight().equals(aPackage.getWeight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getWeight());
    }
}
