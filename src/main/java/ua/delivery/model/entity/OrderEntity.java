package ua.delivery.model.entity;

import java.time.LocalDate;
import java.util.Objects;

public class OrderEntity {
    private final Long id;
    private final Long packageId;
    private final Long paymentId;
    private final Long senderId;
    private final Long receiverId;
    private final LocalDate sentDate;
    private final LocalDate receiveDate;
    private final RouteEntity route;

    public OrderEntity(OrderEntityBuilder orderEntityBuilder) {
        this.id = orderEntityBuilder.id;
        this.route = orderEntityBuilder.route;
        this.packageId = orderEntityBuilder.packageId;
        this.paymentId = orderEntityBuilder.paymentId;
        this.sentDate = orderEntityBuilder.sentDate;
        this.receiveDate = orderEntityBuilder.receiveDate;
        this.senderId = orderEntityBuilder.senderId;
        this.receiverId = orderEntityBuilder.receiverId;
    }

    public static OrderEntityBuilder builder() {
        return new OrderEntityBuilder();
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

    public RouteEntity getRoute() {
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
        OrderEntity order = (OrderEntity) o;
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

    public static class OrderEntityBuilder {
        private Long id;
        private Long packageId;
        private Long paymentId;
        private Long senderId;
        private Long receiverId;
        private LocalDate sentDate;
        private LocalDate receiveDate;
        private RouteEntity route;


        public OrderEntityBuilder() {
        }

        public OrderEntity build() {
            return new OrderEntity(this);
        }

        public OrderEntityBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public OrderEntityBuilder withSenderId(Long senderId) {
            this.senderId = senderId;
            return this;
        }

        public OrderEntityBuilder withReceiverId(Long receiverId) {
            this.receiverId = receiverId;
            return this;
        }

        public OrderEntityBuilder withPackageId(Long packageId) {
            this.packageId = packageId;
            return this;
        }

        public OrderEntityBuilder withPaymentId(Long paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        public OrderEntityBuilder withSentDate(LocalDate sentDate) {
            this.sentDate = sentDate;
            return this;
        }

        public OrderEntityBuilder withReceiveDate(LocalDate receiveDate) {
            this.receiveDate = receiveDate;
            return this;
        }

        public OrderEntityBuilder withRoute(RouteEntity route) {
            this.route = route;
            return this;
        }
    }
}
