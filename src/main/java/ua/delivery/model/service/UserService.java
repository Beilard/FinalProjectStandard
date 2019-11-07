package ua.delivery.model.service;


import ua.delivery.model.domain.User;

import java.util.List;

public interface UserService {
    void register(User user);

    User login(String email, String password);

    List<User> findAll();
}
