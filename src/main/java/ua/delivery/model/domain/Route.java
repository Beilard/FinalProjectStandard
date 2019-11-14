package ua.delivery.model.domain;

import java.util.Objects;

public class Route {
    private final Address origin;
    private final Address destination;
    private int distance;

    private Route(Address origin, Address destination) {
        this.origin = origin;
        this.destination = destination;
        switch (origin.getCity()){

        }
        distance = 0; //need to implement
    }

    public Address getOrigin() {
        return origin;
    }

    public Address getDestination() {
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
        Route route = (Route) o;
        return getDistance() == route.getDistance() &&
                getOrigin().equals(route.getOrigin()) &&
                getDestination().equals(route.getDestination());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrigin(), getDestination(), getDistance());
    }

    @Override
    public String toString() {
        return "Route{" +
                "origin=" + origin +
                ", destination=" + destination +
                ", length=" + distance +
                '}';
    }
}
