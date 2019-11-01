package ua.delivery.model.entity;

public class AddressEntity {
    private Long id;
    private String city;
    private String street;
    private int buildingNumber;

    public AddressEntity(Long id, String city, String street, int buildingNumber) {
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

}
