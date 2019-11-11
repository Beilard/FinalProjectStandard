package ua.delivery.model.dao;

import ua.delivery.model.entity.OrderEntity;

import java.util.Optional;

public interface OrderDao extends CrudDao<OrderEntity, Long> {
    Optional<OrderEntity> findByRouteId(Long id);
}
