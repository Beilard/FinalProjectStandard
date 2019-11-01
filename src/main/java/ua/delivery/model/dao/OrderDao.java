package ua.delivery.model.dao;

import ua.delivery.model.domain.Order;
import ua.delivery.model.entity.OrderEntity;

import java.util.Optional;

public interface OrderDao extends CrudDao<OrderEntity, Long> {
    Optional<Order> findByRouteId(Long id);
}
