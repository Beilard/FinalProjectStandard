package ua.delivery.model.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


public class Order implements Serializable {
    private static final long serialversionUID = 2L;
    private final Long id;
    private final Long packageId;
    private final Long paymentId;
    private final LocalDate sentDate;
    private final LocalDate receiveDate;
    private final Route route;
    private final Double weight;

    public Order(OrderBuilder orderBuilder) {
        this.id = orderBuilder.id;
        this.route = orderBuilder.route;
        this.packageId = orderBuilder.packageId;
        this.paymentId = orderBuilder.paymentId;
        this.sentDate = orderBuilder.sentDate;
        this.receiveDate = orderBuilder.receiveDate;
        this.weight = orderBuilder.weight;
    }

    public static OrderBuilder builder() {
        return new OrderBuilder();
    }

    public Long getId() {
        return id;
    }


    public Long getPackageId() {
        return packageId;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public LocalDate getSentDate() {
        return sentDate;
    }

    public LocalDate getReceiveDate() {
        return receiveDate;
    }

    public Double getWeight() {
        return weight;
    }

    public Route getRoute() {
        return route;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return Objects.equals(getPackageId(), order.getPackageId()) &&
                Objects.equals(getPaymentId(), order.getPaymentId()) &&
                Objects.equals(getSentDate(), order.getSentDate()) &&
                Objects.equals(getReceiveDate(), order.getReceiveDate()) &&
                Objects.equals(getRoute(), order.getRoute()) &&
                Objects.equals(getWeight(), order.getWeight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPackageId(), getPaymentId(), getSentDate(), getReceiveDate(), getRoute(), getWeight());
    }

    public static class OrderBuilder {
        private Long id;
        private Long packageId;
        private Long paymentId;
        private LocalDate sentDate;
        private LocalDate receiveDate;
        private Route route;
        private Double weight;

        public OrderBuilder() {
        }

        public Order build() {
            return new Order(this);
        }

        public OrderBuilder withId(Long id) {
            this.id = id;
            return this;
        }


        public OrderBuilder withPackageId(Long packageId) {
            this.packageId = packageId;
            return this;
        }

        public OrderBuilder withPaymentId(Long paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        public OrderBuilder withSentDate(LocalDate sentDate) {
            this.sentDate = sentDate;
            return this;
        }

        public OrderBuilder withReceiveDate(LocalDate receiveDate) {
            this.receiveDate = receiveDate;
            return this;
        }

        public OrderBuilder withWeight(Double weight) {
            this.weight = weight;
            return this;
        }

        public OrderBuilder withRoute(Route route) {
            this.route = route;
            return this;
        }
    }
}
