package ua.delivery.model.service.implementation;

import org.apache.log4j.Logger;
import ua.delivery.model.dao.UserDao;
import ua.delivery.model.domain.User;
import ua.delivery.model.domain.UserCredentials;
import ua.delivery.model.entity.UserCredentialsEntity;
import ua.delivery.model.entity.UserEntity;
import ua.delivery.model.exception.DataBaseRuntimeException;
import ua.delivery.model.exception.EmailAlreadyTakenException;
import ua.delivery.model.exception.EntityNotFoundException;
import ua.delivery.model.exception.InvalidCredentialsException;
import ua.delivery.model.service.UserService;
import ua.delivery.model.service.encoder.PasswordEncoder;
import ua.delivery.model.service.mapper.UserMapper;
import ua.delivery.model.service.validator.Validator;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
    private final Validator loginValidator;
    private final Validator registrationValidator;
    private final UserDao userDao;
    private final UserMapper userMapper;

    public UserServiceImpl(Validator registrationValidator, Validator loginValidator, UserDao userDao, UserMapper userMapper) {
        this.loginValidator = loginValidator;
        this.registrationValidator = registrationValidator;
        this.userDao = userDao;
        this.userMapper = userMapper;
    }

    @Override
    public void register(User user) {
        registrationValidator.validate(user);
        if (userDao.findByEmail(user.getUserCredentials().getEmail()).isPresent()) {
            LOGGER.warn("Provided email " + user.getUserCredentials().getEmail() + " is already taken");
            throw new EmailAlreadyTakenException("Email already taken!");
        }

        final UserEntity encodedEntity = UserEntity.builder()
                .withName(user.getName())
                .withSurname(user.getSurname())
                .withUserCredentials(new UserCredentialsEntity(user.getUserCredentials().getEmail(),
                        PasswordEncoder.encrypt(user.getUserCredentials().getPassword())))
                .withRole(user.getRole())
                .build();

        userDao.save(encodedEntity);
    }

    @Override
    public User login(String email, String password) {
        loginValidator.validate(new UserCredentials(email, password));

        Optional<UserEntity> user = userDao.findByEmail(email);

        if (!(user.isPresent())) {
            LOGGER.error("User account not found!");
            throw new EntityNotFoundException("Client not found!");
        }
        String dbPassword = null;
        try {
            dbPassword = PasswordEncoder.decrypt(user.get().getUserCredentials().getPassword());
        } catch (RuntimeException e) {
            LOGGER.error("User has no password: " + user);
            throw new DataBaseRuntimeException(e);
        }
        if (!(Objects.equals(dbPassword, password))) {
            LOGGER.error("Incorrect email or password!");
            throw new InvalidCredentialsException("Incorrect email or password!");
        }
        return userMapper.mapEntityToUser(userDao.findByEmail(email).get());
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll().stream()
                .map(userMapper::mapEntityToUser)
                .collect(Collectors.toList());
    }
}
