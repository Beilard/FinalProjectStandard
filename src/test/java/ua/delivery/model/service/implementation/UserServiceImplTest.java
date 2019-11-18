package ua.delivery.model.service.implementation;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import ua.delivery.model.dao.UserDao;
import ua.delivery.model.domain.Role;
import ua.delivery.model.domain.User;
import ua.delivery.model.domain.UserCredentials;
import ua.delivery.model.entity.UserCredentialsEntity;
import ua.delivery.model.entity.UserEntity;
import ua.delivery.model.exception.DataBaseRuntimeException;
import ua.delivery.model.exception.EmailAlreadyTakenException;
import ua.delivery.model.exception.EntityNotFoundException;
import ua.delivery.model.exception.InvalidCredentialsException;
import ua.delivery.model.service.encoder.PasswordEncoder;
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

    private static final String EMAIL = "savant@mail.com";

    private static final String PASSWORD = "Qwerty123#";

    private final UserEntity exampleEntity = initUserEntity();
    private final User exampleUser = initUser();

    @Mock
    private RegistrationValidator registrationValidator;
    @Mock
    private LoginValidator loginValidator;
    @Mock
    private UserDao userDao;
    @Mock
    private UserMapper userMapper;
    @Mock
    private PasswordEncoder passwordEncoder;
    @InjectMocks
    private UserServiceImpl userService;

    @Before
    public void setUp() {
        List<UserEntity> entities = Collections.singletonList(exampleEntity);
        when(userDao.findByEmail(EMAIL)).thenReturn(Optional.of(exampleEntity));
        when(userDao.findAll()).thenReturn(entities);
        when(userDao.findByEmail(EMAIL)).thenReturn(Optional.of(exampleEntity));
        when(userMapper.mapEntityToUser(exampleEntity)).thenReturn(initUser());
        when(passwordEncoder.decrypt(PASSWORD)).thenReturn(PASSWORD);
    }

    @After
    public void resetMocks() {
        reset(userDao, userMapper, registrationValidator, loginValidator);
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void findAllShouldHaveNormalBehaviour() {
        List<User> expected = new ArrayList<>();
        expected.add(userMapper.mapEntityToUser(exampleEntity));
        List<User> actual = userService.findAll();
        assertEquals(expected, actual);
    }

    @Test
    public void registerShouldThrowException() {
        exception.expect(EmailAlreadyTakenException.class);
        userService.register(exampleUser);
    }

    @Test
    public void loginShouldThrowNoPasswordExceptions() {
        exception.expect(EntityNotFoundException.class);
        userService.login("123@mail.com", "1234");
    }

    @Test
    public void loginShouldThrowWrongCredentials() {
        exception.expect(InvalidCredentialsException.class);
        userService.login(EMAIL, "1234");
    }

    @Test
    public void loginShouldHaveNormalBehaviour() {
        User actualUser = userService.login(EMAIL, PASSWORD);
        assertEquals(exampleUser, actualUser);
    }

    private UserEntity initUserEntity() {
        return UserEntity.builder()
                .withId(ID)
                .withName(NAME)
                .withSurname(SURNAME)
                .withUserCredentials(new UserCredentialsEntity(EMAIL, PASSWORD))
                .withRole(Role.USER)
                .build();
    }

    private User initUser() {
        return User.builder()
                .withId(ID)
                .withName(NAME)
                .withSurname(SURNAME)
                .withUserCredentials(new UserCredentials(EMAIL, PASSWORD))
                .withRole(Role.USER)
                .build();
    }
}