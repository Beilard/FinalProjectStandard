package ua.delivery.model.domain;

import java.util.Objects;


public class Address {
    private Long id;
    private String city;
    private String street;
    private int buildingNumber;

    public Address(Long id, String city, String street, int buildingNumber) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
    }

    public Long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Address address = (Address) o;
        return getBuildingNumber() == address.getBuildingNumber() &&
                getCity().equals(address.getCity()) &&
                getStreet().equals(address.getStreet());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getStreet(), getBuildingNumber());
    }
}
