package ua.delivery.model.service.implementation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import ua.delivery.model.dao.UserDao;
import ua.delivery.model.domain.Role;
import ua.delivery.model.domain.User;
import ua.delivery.model.entity.UserCredentialsEntity;
import ua.delivery.model.entity.UserEntity;
import ua.delivery.model.exception.DataBaseRuntimeException;
import ua.delivery.model.exception.EmailAlreadyTakenException;
import ua.delivery.model.exception.InvalidCredentialsException;
import ua.delivery.model.service.mapper.UserMapper;
import ua.delivery.model.service.validator.LoginValidator;
import ua.delivery.model.service.validator.RegistrationValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
    private static final Long ID = 0L;

    private static final String NAME = "Ivan";

    private static final String SURNAME = "Popov";

    private static final String EMAIL = "Ivan@mail.com";

    private static final String PASSWORD = "Qwerty123#";

    @Mock
    private RegistrationValidator registrationValidator;
    @Mock
    private LoginValidator loginValidator;
    @Mock
    private UserDao userDao;
    @Mock
    private UserMapper userMapper;
    @InjectMocks
    private UserServiceImpl userService;

    private final UserEntity exampleEntity = initUserEntity();

    private UserEntity initUserEntity() {
        return UserEntity.builder()
                .withId(ID)
                .withName(NAME)
                .withSurname(SURNAME)
                .withUserCredentials(new UserCredentialsEntity(EMAIL, PASSWORD))
                .withRole(Role.USER)
                .build();
    }

    private final User exampleUser = userMapper.mapEntityToUser(exampleEntity);

    @Before
    public void setUp() {
        when(userDao.findByEmail(EMAIL)).thenReturn(Optional.of(exampleEntity));
        List<UserEntity> entities = Collections.singletonList(exampleEntity);
        when(userDao.findAll(1, 1)).thenReturn(entities);
        when(userDao.findByEmail(EMAIL)).thenReturn(Optional.of(exampleEntity));
    }

    @After
    public void resetMocks() {
        reset(userDao, userMapper, registrationValidator, loginValidator);
    }

    @Test(expected = EmailAlreadyTakenException.class)
    public void registerShouldThrowException() {
        userService.register(userMapper.mapEntityToUser(exampleEntity));
    }

    @Test(expected = DataBaseRuntimeException.class)
    public void loginShouldThrowNoPasswordExceptions() {
        userService.login("123@mail.com", "1234");
    }

    @Test(expected = InvalidCredentialsException.class)
    public void loginShouldThrowWrongCredentials() {
        userService.login(EMAIL, "1234");
    }

    @Test
    public void loginShouldHaveNormalBehaviour() {
        userService.register(exampleUser);
    }

    @Test
    public void findAllShouldHaveNormalBehaviour() {
        List<User> expected = new ArrayList<>();
        expected.add(userMapper.mapEntityToUser(exampleEntity));
        List<User> actual = userService.findAll(1, 1);
        assertEquals(expected, actual);
    }
}