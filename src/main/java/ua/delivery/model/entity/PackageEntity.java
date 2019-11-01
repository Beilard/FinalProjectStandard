package ua.delivery.model.entity;

import java.util.Objects;

public class PackageEntity {
    private final Long id;
    private final String type;
    private final Double weight;

    public PackageEntity(Long id, String type, Double weight) {
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
        PackageEntity that = (PackageEntity) o;
        return getId().equals(that.getId()) &&
                getType().equals(that.getType()) &&
                getWeight().equals(that.getWeight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getType(), getWeight());
    }
}
