package ua.delivery.model.entity;

import java.util.Date;

public class Order {
    private Integer id;
    private Integer userId;
    private Integer packageId;
    private Integer paymentId;
    private Date receiveDate;
    private Double weight;

    public Order(Integer id, Integer userId, Integer packageId, Integer paymentId, Date receiveDate, Double weight) {
        this.id = id;
        this.userId = userId;
        this.packageId = packageId;
        this.paymentId = paymentId;
        this.receiveDate = receiveDate;
        this.weight = weight;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getPackageId() {
        return packageId;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public Double getWeight() {
        return weight;
    }
}
