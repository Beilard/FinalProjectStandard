package ua.delivery.model.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Payment implements Serializable {
    private static final long serialversionUID = 3L;
    private final Long id;
    private final Double amount;
    private final LocalDate date;
    private final boolean isComplete;
    private final Long orderId;

    public Payment(PaymentBuilder paymentBuilder) {
        this.id = paymentBuilder.id;
        this.amount = paymentBuilder.amount;
        this.date = paymentBuilder.date;
        this.isComplete = paymentBuilder.isComplete;
        this.orderId = paymentBuilder.orderId;
    }

    public static PaymentBuilder builder() {
        return new PaymentBuilder();
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
        Payment payment = (Payment) o;
        return isComplete() == payment.isComplete() &&
                getAmount().equals(payment.getAmount()) &&
                getDate().equals(payment.getDate()) &&
                getOrderId().equals(payment.getOrderId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAmount(), getDate(), isComplete(), getOrderId());
    }

    public static class PaymentBuilder {
        private Long id;
        private Double amount;
        private LocalDate date;
        private boolean isComplete;
        private Long orderId;

        public PaymentBuilder() {
        }

        public Payment build() {
            return new Payment(this);
        }

        public PaymentBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public PaymentBuilder withAmount(Double amount) {
            this.amount = amount;
            return this;
        }

        public PaymentBuilder withDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public PaymentBuilder withComplete(boolean complete) {
            isComplete = complete;
            return this;
        }

        public PaymentBuilder withOrderId(Long orderId) {
            this.orderId = orderId;
            return this;
        }
    }
}
