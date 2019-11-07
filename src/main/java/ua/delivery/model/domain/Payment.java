package ua.delivery.model.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Payment {
    private final Long id;
    private final long amount;
    private final LocalDate date;
    private final boolean isComplete;
    private final Long orderId;

    private Payment(PaymentBuilder paymentBuilder) {
        this.id = paymentBuilder.id;
        this.amount = paymentBuilder.amount;
        this.date = paymentBuilder.date;
        this.isComplete = paymentBuilder.isComplete;
        this.orderId = paymentBuilder.orderId;
    }

    public static PaymentBuilder builder() {
        return new PaymentBuilder();
    }

    public static PaymentBuilder builder(Payment payment) {
        return new PaymentBuilder(payment);
    }

    public Long getId() {
        return id;
    }

    public long getAmount() {
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
                getAmount() == payment.getAmount() &&
                getDate().equals(payment.getDate()) &&
                getOrderId().equals(payment.getOrderId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAmount(), getDate(), isComplete(), getOrderId());
    }

    public static class PaymentBuilder {
        private Long id;
        private long amount;
        private LocalDate date;
        private boolean isComplete;
        private Long orderId;

        private PaymentBuilder() {
        }

        private PaymentBuilder(Payment payment) {
            this.id =payment. id;
            this.amount =payment. amount;
            this.date =payment. date;
            this.isComplete =payment. isComplete;
            this.orderId =payment. orderId;
        }

        public Payment build() {
            return new Payment(this);
        }

        public PaymentBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public PaymentBuilder withAmount(long amount) {
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
