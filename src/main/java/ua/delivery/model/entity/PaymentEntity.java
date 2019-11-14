package ua.delivery.model.entity;

import java.time.LocalDate;
import java.util.Objects;

public class PaymentEntity {
    private final Long id;
    private final long amount; //decimal or in coins
    private final LocalDate date;
    private final boolean isComplete;


    private PaymentEntity(PaymentEntityBuilder paymentEntityBuilder) {
        this.id = paymentEntityBuilder.id;
        this.amount = paymentEntityBuilder.amount;
        this.date = paymentEntityBuilder.date;
        this.isComplete = paymentEntityBuilder.isComplete;
    }

    public static PaymentEntityBuilder builder() {
        return new PaymentEntityBuilder();
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
        PaymentEntity that = (PaymentEntity) o;
        return isComplete() == that.isComplete() &&
                getId().equals(that.getId()) &&
                Objects.equals(getAmount(), that.getAmount()) &&
                Objects.equals(getDate(), that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAmount(), getDate(), isComplete());
    }

    public static class PaymentEntityBuilder {
        private Long id;
        private long amount;
        private LocalDate date;
        private boolean isComplete;

        public PaymentEntityBuilder() {
        }

        public PaymentEntity build() {
            return new PaymentEntity(this);
        }

        public PaymentEntityBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public PaymentEntityBuilder withAmount(Long amount) {
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

    }
}
