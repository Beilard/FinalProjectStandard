package ua.delivery.model.service;

import ua.delivery.model.domain.Address;
import ua.delivery.model.domain.Order;
import ua.delivery.model.domain.User;

import java.util.List;

public interface UserService {
    void register(User user);

    User login(String email, String password);

    Order send(Address originAddress, Address destinationAddress, double weight);

    void receive(Long id);

    List<Order> viewHistory();

}
