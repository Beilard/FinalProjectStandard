package ua.delivery.model.dao;

import ua.delivery.model.domain.Payment;
import ua.delivery.model.entity.PaymentEntity;

import java.util.Optional;

public interface PaymentDao extends CrudDao<PaymentEntity, Long> {
    Optional<PaymentEntity> findByOrderId(Long id);
}
