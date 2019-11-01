package ua.delivery.model.dao;

import ua.delivery.model.domain.User;
import ua.delivery.model.entity.UserEntity;

import java.util.Optional;

public interface UserDao extends CrudDao<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);

}
