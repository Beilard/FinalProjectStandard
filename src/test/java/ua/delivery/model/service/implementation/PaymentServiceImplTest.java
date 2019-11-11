package ua.delivery.model.service.implementation;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ua.delivery.model.dao.PaymentDao;
import ua.delivery.model.domain.Payment;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.reset;

@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceImplTest {
    @Mock
    private PaymentDao paymentDao;

    @InjectMocks
    private PaymentServiceImpl paymentService;

    @After
    public void resetMocks() {
        reset(paymentDao);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createPaymentShouldThrowIllegalArgumentId() {
        paymentService.createPayment(-1L, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createPaymentShouldThrowIllegalArgumentAmount() {
        paymentService.createPayment(1L, -1);
    }

    @Test
    public void createPaymentShouldHaveNormalBehaviour() {
        int amount = 10;
        Long id = 2L;
        final Payment expected = Payment.builder()
                .withAmount(amount)
                .withComplete(false)
                .withDate(LocalDate.now())
                .withOrderId(id)
                .build();
        Optional<Payment> payment = paymentService.createPayment(id, amount);
        assertEquals(Optional.of(expected), payment);
    }

    @Test(expected = IllegalArgumentException.class)
    public void completePaymentShouldThrowNull() {
        paymentService.completePayment(null);
    }

    @Test
    public void completePaymentShouldHaveNormalBehaviour() {
        final Payment payment = Payment.builder()
                .withAmount(10)
                .withComplete(false)
                .withDate(LocalDate.now())
                .withOrderId(1L)
                .build();
        Optional<Payment> expected = paymentService.completePayment(payment);

        final Optional<Payment> actual = Optional.ofNullable(Payment.builder(payment)
                .withComplete(true)
                .build());
        assertEquals(expected, actual);

    }
}