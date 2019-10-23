package ua.delivery.model.entity;

import java.util.Date;

public class Payment {
    private Integer id;
    private Double amount;
    private Date date;
    private boolean isComplete;

    public Payment(Integer id, Double amount, Date date, boolean isComplete) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.isComplete = isComplete;
    }

    public Integer getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public boolean isComplete() {
        return isComplete;
    }
}
