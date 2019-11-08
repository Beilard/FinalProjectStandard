package ua.delivery.model.service.mapper;

import org.hamcrest.core.Is;
import org.junit.Test;
import ua.delivery.model.domain.Role;
import ua.delivery.model.domain.User;
import ua.delivery.model.domain.UserCredentials;
import ua.delivery.model.entity.UserCredentialsEntity;
import ua.delivery.model.entity.UserEntity;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class UserMapperTest {

    private static final Long ID = 0L;
    private static final String NAME = "Ivan";
    private static final String SURNAME = "Popov";
    private static final String EMAIL = "Ivan@mail.com";
    private static final String PASSWORD = "Qwerty123#";


    @Test
    public void mapEntityToUser_shouldReturnUser() {
        final UserEntity userEntity = UserEntity.builder()
                .withId(ID)
                .withName(NAME)
                .withSurname(SURNAME)
                .withUserCredentials(new UserCredentialsEntity(EMAIL, PASSWORD))
                .withRole(Role.USER)
                .build();

        final User user = UserMapper.mapEntityToUser(userEntity);

        assertThat("Id mapping has failed", user.getId(), is(ID));
        assertThat("Name mapping has failed", user.getName(), is(NAME));
        assertThat("Credentials mapping has failed", user.getUserCredentials(), is(new UserCredentials(EMAIL, PASSWORD)));
        assertThat("Role mapping has failed", user.getRole(), is(Role.USER));
    }

    @Test
    public void mapUserToEntity() {
        final User user = User.builder()
                .withId(ID)
                .withName(NAME)
                .withSurname(SURNAME)
                .withUserCredentials(new UserCredentials(EMAIL, PASSWORD))
                .withRole(Role.USER)
                .build();

        final UserEntity userEntity = UserMapper.mapUserToEntity(user);

        assertThat("Id mapping has failed", userEntity.getId(), is(ID));
        assertThat("Name mapping has failed", userEntity.getName(), is(NAME));
        assertThat("Credentials mapping has failed", userEntity.getUserCredentials(), is(new UserCredentials(EMAIL, PASSWORD)));
        assertThat("Role mapping has failed", userEntity.getRole(), is(Role.USER));
    }
}