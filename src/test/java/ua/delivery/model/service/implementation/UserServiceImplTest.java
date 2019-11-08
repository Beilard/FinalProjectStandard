package ua.delivery.model.service.implementation;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import ua.delivery.model.dao.UserDao;
import ua.delivery.model.domain.Role;
import ua.delivery.model.entity.UserCredentialsEntity;
import ua.delivery.model.entity.UserEntity;
import ua.delivery.model.service.UserService;
import ua.delivery.model.service.validator.LoginValidator;
import ua.delivery.model.service.validator.RegistrationValidator;

import java.util.List;
import java.util.Optional;

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
    @InjectMocks
    private UserService userService;

    private final UserEntity example = UserEntity.builder()
            .withId(ID)
            .withName(NAME)
            .withSurname(SURNAME)
            .withUserCredentials(new UserCredentialsEntity(EMAIL, PASSWORD))
            .withRole(Role.USER)
            .build();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(userDao.findByEmail(EMAIL)).thenReturn(Optional.of(example));
//        Mockito.when(userDao.findAll(1,1)).thenReturn(new List<UserEntity>);
    }

    @Test
    public void register() {

    }

    @Test
    public void login() {
    }

    @Test
    public void findAll() {

    }
}