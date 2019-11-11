package ua.delivery.model.entity;

public class RouteEntity {
    private final AddressEntity origin;
    private final AddressEntity destination;
    private final int distance;

    public RouteEntity(AddressEntity origin, AddressEntity destination) {
        this.origin = origin;
        this.destination = destination;
        distance = 0; //need to implement
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
}
