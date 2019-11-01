package ua.delivery.model.entity;

import java.time.LocalDate;
import java.util.Objects;

public class PaymentEntity {
    private final Long id;
    private final Double amount;
    private final LocalDate date;
    private final boolean isComplete;
    private final Long orderId;

    public PaymentEntity(PaymentEntityBuilder paymentEntityBuilder) {
        this.id = paymentEntityBuilder.id;
        this.amount = paymentEntityBuilder.amount;
        this.date = paymentEntityBuilder.date;
        this.isComplete = paymentEntityBuilder.isComplete;
        this.orderId = paymentEntityBuilder.orderId;
    }

    public static PaymentEntityBuilder builder() {
        return new PaymentEntityBuilder();
    }

    public Long getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public Long getOrderId() {
        return orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PaymentEntity that = (PaymentEntity) o;
        return isComplete() == that.isComplete() &&
                getId().equals(that.getId()) &&
                Objects.equals(getAmount(), that.getAmount()) &&
                Objects.equals(getDate(), that.getDate()) &&
                Objects.equals(getOrderId(), that.getOrderId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAmount(), getDate(), isComplete(), getOrderId());
    }

    public static class PaymentEntityBuilder {
        private Long id;
        private Double amount;
        private LocalDate date;
        private boolean isComplete;
        private Long orderId;

        public PaymentEntityBuilder() {
        }

        public PaymentEntity build() {
            return new PaymentEntity(this);
        }

        public PaymentEntityBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public PaymentEntityBuilder withAmount(Double amount) {
            this.amount = amount;
            return this;
        }

        public PaymentEntityBuilder withDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public PaymentEntityBuilder withComplete(boolean complete) {
            isComplete = complete;
            return this;
        }

        public PaymentEntityBuilder withOrderId(Long orderId) {
            this.orderId = orderId;
            return this;
        }
    }
}
