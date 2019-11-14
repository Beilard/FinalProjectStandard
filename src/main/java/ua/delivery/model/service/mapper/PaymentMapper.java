package ua.delivery.model.service.mapper;

import ua.delivery.model.domain.Payment;
import ua.delivery.model.entity.PaymentEntity;

public class PaymentMapper {
    public Payment mapEntityToPayment(PaymentEntity paymentEntity) {
        return Payment.builder()
                .withAmount(paymentEntity.getAmount())
                .withComplete(paymentEntity.isComplete())
                .withDate(paymentEntity.getDate())
                .withId(paymentEntity.getId())
                .build();
    }

    public PaymentEntity mapPaymentToEntity(Payment payment) {
        return PaymentEntity.builder()
                .withAmount(payment.getAmount())
                .withComplete(payment.isComplete())
                .withDate(payment.getDate())
                .withId(payment.getId())
                .build();
    }
}
