package ua.delivery.model.service.implementation;

import org.apache.log4j.Logger;
import ua.delivery.model.dao.PaymentDao;
import ua.delivery.model.domain.Payment;
import ua.delivery.model.service.PaymentService;
import ua.delivery.model.service.mapper.PaymentMapper;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

public class PaymentServiceImpl implements PaymentService {
    private static final Logger LOGGER = Logger.getLogger(PaymentServiceImpl.class);
    private final PaymentDao paymentDao;
    private final PaymentMapper paymentMapper;

    public PaymentServiceImpl(PaymentDao paymentDao, PaymentMapper paymentMapper) {
        this.paymentDao = paymentDao;
        this.paymentMapper = paymentMapper;
    }

    @Override
    public Optional<Payment> createPayment(Long orderId, long amount) {
        if (orderId < 0 && amount <= 0) {
            throw new IllegalArgumentException();
        }
        final Payment payment = Payment.builder()
                .withAmount(amount)
                .withComplete(false)
                .withDate(LocalDate.now())
                .build();
        paymentDao.save(paymentMapper.mapPaymentToEntity(payment));
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
