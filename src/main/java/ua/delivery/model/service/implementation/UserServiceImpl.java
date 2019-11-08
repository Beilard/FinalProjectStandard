package ua.delivery.model.service.implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.delivery.model.dao.UserDao;
import ua.delivery.model.domain.Order;
import ua.delivery.model.domain.User;
import ua.delivery.model.domain.UserCredentials;
import ua.delivery.model.entity.UserEntity;
import ua.delivery.model.exception.DataBaseRuntimeException;
import ua.delivery.model.exception.EmailAlreadyTakenException;
import ua.delivery.model.exception.EntityNotFoundException;
import ua.delivery.model.exception.IncorrectEmailOrPasswordException;
import ua.delivery.model.service.UserService;
import ua.delivery.model.service.encoder.PasswordEncoder;
import ua.delivery.model.service.mapper.UserMapper;
import ua.delivery.model.service.validator.RegistrationValidator;
import ua.delivery.model.service.validator.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final Validator loginValidator;
    private final Validator registrationValidator;
    private final UserDao userDao;

    public UserServiceImpl(Validator registrationValidator, Validator loginValidator, UserDao userDao) {
        this.loginValidator = loginValidator;
        this.registrationValidator = registrationValidator;
        this.userDao = userDao;
    }

    @Override
    public void register(User user) {
        registrationValidator.validate(user);
        if (userDao.findByEmail(user.getUserCredentials().getEmail()).isPresent()) {
            LOGGER.warn("Provided email " + user.getUserCredentials().getEmail() + " is already taken");
            throw new EmailAlreadyTakenException("Email already taken!");
        }
        userDao.save(UserMapper.mapUserToEntity(user));
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
            throw new IncorrectEmailOrPasswordException("Incorrect email or password!");
        }
        return UserMapper.mapEntityToUser(userDao.findByEmail(email).get());
    }

    @Override
    public List<User> findAll(int start, int total) {
        return userDao.findAll(start, total).stream()
                .map(UserMapper::mapEntityToUser)
                .collect(Collectors.toList());
    }
}
