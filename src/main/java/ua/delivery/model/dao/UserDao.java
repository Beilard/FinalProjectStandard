package ua.delivery.model.dao;

import ua.delivery.model.domain.User;

import java.util.Optional;

public interface UserDao extends CrudDao<User, Long> {
    Optional<User> findByEmail(String email);

}
