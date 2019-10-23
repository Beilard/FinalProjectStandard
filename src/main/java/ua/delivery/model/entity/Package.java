package ua.delivery.model.entity;

public class Package {
    private Integer id;
    private String type; //enum later
    private Double weight;
    private Double price;

    public Package(Integer id, String type, Double weight, Double price) {
        this.id = id;
        this.type = type;
        this.weight = weight;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getPrice() {
        return price;
    }
}
