package ua.delivery.model.service.implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.delivery.model.dao.PaymentDao;
import ua.delivery.model.domain.Payment;
import ua.delivery.model.service.PaymentService;
import ua.delivery.model.service.mapper.PaymentMapper;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

public class PaymentServiceImpl implements PaymentService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentServiceImpl.class);
    private final PaymentDao paymentDao;

    public PaymentServiceImpl(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Override
    public Optional<Payment> createPayment(Long orderId, long amount) {
        if (orderId < 0 && amount <= 0) {
            throw new IllegalArgumentException();
        }
        final Payment payment = Payment.builder()
                .withAmount(amount)
                .withComplete(false)
                .withDate(LocalDate.now()) //wrap for tests
                .withOrderId(orderId)
                .build();
        paymentDao.save(PaymentMapper.mapPaymentToEntity(payment));
        return Optional.of(payment);
    }


    @Override
    public Optional<Payment> completePayment(Payment payment) {
        if (Objects.isNull(payment)) {
            throw new IllegalArgumentException();
        }
        final Payment newPayment = Payment.builder(payment)
                .withComplete(true)
                .build();

        return Optional.ofNullable(newPayment);
    }
}
