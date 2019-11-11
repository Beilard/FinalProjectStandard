package ua.delivery.model.service;

import ua.delivery.model.domain.Payment;

import java.util.Optional;

public interface PaymentService {
    Optional<Payment> createPayment(Long orderId, long amount);

    Optional<Payment> completePayment(Payment payment);
}
