package ua.delivery.model.service;

import ua.delivery.model.domain.Order;

import java.util.Optional;

public interface OrderService {
    Optional<Order> createOrder();

    Optional<Order> finishOrder(Order order);
}
