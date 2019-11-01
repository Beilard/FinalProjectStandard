package ua.delivery.model.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


public class Order {
    private final Long id;
    private final Long packageId;
    private final Long paymentId;
    private final Long senderId;
    private final Long receiverId;
    private final LocalDate sentDate;
    private final LocalDate receiveDate;
    private final Route route;

    public Order(OrderBuilder orderBuilder) {
        this.id = orderBuilder.id;
        this.route = orderBuilder.route;
        this.packageId = orderBuilder.packageId;
        this.paymentId = orderBuilder.paymentId;
        this.sentDate = orderBuilder.sentDate;
        this.receiveDate = orderBuilder.receiveDate;
        this.senderId = orderBuilder.senderId;
        this.receiverId = orderBuilder.receiverId;
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
                Objects.equals(getRoute(), order.getRoute());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPackageId(), getPaymentId(), getSentDate(), getReceiveDate(), getRoute());
    }

    public static class OrderBuilder {
        private Long id;
        private Long packageId;
        private Long paymentId;
        private Long senderId;
        private Long receiverId;
        private LocalDate sentDate;
        private LocalDate receiveDate;
        private Route route;


        public OrderBuilder() {
        }

        public Order build() {
            return new Order(this);
        }

        public OrderBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public OrderBuilder withSenderId(Long senderId) {
            this.senderId = senderId;
            return this;
        }

        public OrderBuilder withReceiverId(Long receiverId) {
            this.receiverId = receiverId;
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

        public OrderBuilder withRoute(Route route) {
            this.route = route;
            return this;
        }
    }
}
