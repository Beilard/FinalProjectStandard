package ua.delivery.model.service.mapper;

import ua.delivery.model.domain.User;
import ua.delivery.model.domain.UserCredentials;
import ua.delivery.model.entity.UserCredentialsEntity;
import ua.delivery.model.entity.UserEntity;

public class UserMapper {
    public User mapEntityToUser(UserEntity userEntity) {
        return User.builder()
                .withId(userEntity.getId())
                .withName(userEntity.getName())
                .withSurname(userEntity.getSurname())
                .withUserCredentials(getUserCredentials(userEntity.getUserCredentials().getEmail(), userEntity.getUserCredentials().getPassword()))
                .withRole(userEntity.getRole())
                .build();
    }

    public UserEntity mapUserToEntity (User user) {
        return UserEntity.builder()
                .withId(user.getId())
                .withName(user.getName())
                .withSurname(user.getSurname())
                .withUserCredentials(getUserCredentialsEntity(user.getUserCredentials().getEmail(), user.getUserCredentials().getPassword()))
                .withRole(user.getRole())
                .build();
    }

    private UserCredentials getUserCredentials(String email, String password) {
        return new UserCredentials(email, password);
    }

    private UserCredentialsEntity getUserCredentialsEntity(String email, String password) {
        return new UserCredentialsEntity(email, password);
    }
}
