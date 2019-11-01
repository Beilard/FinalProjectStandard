package ua.delivery.model.service.validator;

import ua.delivery.model.dao.UserDao;
import ua.delivery.model.domain.User;
import ua.delivery.model.domain.UserCredentials;
import ua.delivery.model.exception.EmailAlreadyTakenException;
import ua.delivery.model.exception.EntityNotFoundException;
import ua.delivery.model.exception.InvalidEmailFormatException;

import java.util.Objects;

public class RegistrationValidator<E> implements Validator<User> {
    private static final String EMAIL_REGEX = "^(.+)@(.+)$";
    private static final String PASSWORD_REGEX = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

    private final UserDao userDao;

    public RegistrationValidator(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void validate(User user) {
        UserCredentials userCredential = user.getUserCredentials();

        if (Objects.isNull(userCredential)) {
            throw new EntityNotFoundException("Provided object is null!");
        }

        if (!userCredential.getEmail().matches(EMAIL_REGEX)) {
            throw new InvalidEmailFormatException("Email format not supported");
        }

        if (!userCredential.getPassword().matches(PASSWORD_REGEX)) {
            throw new InvalidEmailFormatException("Password format not supported");
        }

        if (userDao.findByEmail(userCredential.getEmail()).isPresent()) {
            throw new EmailAlreadyTakenException("Email already taken!");
        }

    }
}
