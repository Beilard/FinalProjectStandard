package ua.delivery.model.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Payment {
    private final Long id;
    private final long amount;
    private final LocalDate date;
    private final boolean isComplete;

    private Payment(PaymentBuilder paymentBuilder) {
        this.id = paymentBuilder.id;
        this.amount = paymentBuilder.amount;
        this.date = paymentBuilder.date;
        this.isComplete = paymentBuilder.isComplete;
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
                getDate().equals(payment.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAmount(), getDate(), isComplete());
    }

    public static class PaymentBuilder {
        private Long id;
        private long amount;
        private LocalDate date;
        private boolean isComplete;

        private PaymentBuilder() {
        }

        private PaymentBuilder(Payment payment) {
            this.id =payment. id;
            this.amount =payment. amount;
            this.date =payment. date;
            this.isComplete =payment. isComplete;
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
    }
}
