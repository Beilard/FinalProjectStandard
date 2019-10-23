package ua.delivery.model.entity;

public class Address {
    private Integer id;
    private String city;
    private String street;
    private int buildingNumber;

    public Address(Integer id, String city, String street, int buildingNumber) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
    }

    public Integer getId() {
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
}
