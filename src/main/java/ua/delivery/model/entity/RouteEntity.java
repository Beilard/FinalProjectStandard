package ua.delivery.model.entity;

import java.util.Objects;

public class RouteEntity {
    private final AddressEntity origin;
    private final AddressEntity destination;
    private final int distance;

    public RouteEntity(AddressEntity origin, AddressEntity destination) {
        this.origin = origin;
        this.destination = destination;
        distance = -1; //need to implement
    }

    public AddressEntity getOrigin() {
        return origin;
    }

    public AddressEntity getDestination() {
        return destination;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RouteEntity that = (RouteEntity) o;
        return getDistance() == that.getDistance() &&
                Objects.equals(getOrigin(), that.getOrigin()) &&
                Objects.equals(getDestination(), that.getDestination());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrigin(), getDestination(), getDistance());
    }
}
