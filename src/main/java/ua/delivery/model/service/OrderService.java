package ua.delivery.model.service;

import ua.delivery.model.domain.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    void createOrder(Order order);

    void finishOrder(Order order);

    List<Order> displayAllBySender(Long id);

    List<Order> displayAll();
}
