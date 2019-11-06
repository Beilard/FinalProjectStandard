package ua.delivery.model.service.implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.delivery.model.dao.UserDao;
import ua.delivery.model.domain.Order;
import ua.delivery.model.domain.User;
import ua.delivery.model.domain.UserCredentials;
import ua.delivery.model.service.UserService;
import ua.delivery.model.service.mapper.UserMapper;
import ua.delivery.model.service.validator.RegistrationValidator;
import ua.delivery.model.service.validator.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
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
    }

    @Override
    public User login(String email, String password) {
        loginValidator.validate(new UserCredentials(email, password));
        return UserMapper.mapEntityToUser(userDao.findByEmail(email).get());  }

    @Override
    public List<User> findAll() {
        return userDao.findAll().stream()
                .map(UserMapper::mapEntityToUser)
                .collect(Collectors.toList());
    }
}
