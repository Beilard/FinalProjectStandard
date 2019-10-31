package ua.delivery.model.dao;

import ua.delivery.model.domain.Address;
import ua.delivery.model.domain.Order;

import java.util.Optional;

public interface OrderDao extends CrudDao<Order, Long> {
    Optional<Order> findByOrigin(Address address);
    Optional<Order> findByDestination(Address address);
}
