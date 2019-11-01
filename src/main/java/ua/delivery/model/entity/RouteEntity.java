package ua.delivery.model.entity;

public class RouteEntity {
    private final AddressEntity origin;
    private final AddressEntity destination;
    private int length;

    public RouteEntity(AddressEntity origin, AddressEntity destination) {
        this.origin = origin;
        this.destination = destination;
        length = 0; //need to implement
    }

    public AddressEntity getOrigin() {
        return origin;
    }

    public AddressEntity getDestination() {
        return destination;
    }

    public int getLength() {
        return length;
    }
}
