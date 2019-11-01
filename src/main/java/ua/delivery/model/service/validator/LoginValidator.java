package ua.delivery.model.service.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.delivery.model.dao.implementation.UserDaoImpl;
import ua.delivery.model.domain.User;
import ua.delivery.model.domain.UserCredentials;
import ua.delivery.model.entity.UserEntity;
import ua.delivery.model.exception.EntityNotFoundException;
import ua.delivery.model.exception.IncorrectEmailOrPasswordException;
import ua.delivery.model.exception.InvalidEmailFormatException;
import ua.delivery.model.exception.InvalidPasswordFormatException;
import ua.delivery.model.service.encoder.PasswordEncoder;

import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginValidator<E> implements Validator<UserCredentials> {
    private static final String EMAIL_REGEX = "^(.+)@(.+)$";
    private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

    private Logger logger = LoggerFactory.getLogger("LoginValidator.class");

    private final UserDaoImpl userDao;

    public LoginValidator(UserDaoImpl userDao) {
        this.userDao = userDao;

    }

    @Override
    public void validate(UserCredentials userCredential) {

        if (Objects.isNull(userCredential)) {
            throw new EntityNotFoundException("Provided object is null!");
        }

        if (!userCredential.getEmail().matches(EMAIL_REGEX)) {
            logger.error("Email format not supported " + userCredential.getEmail());
            throw new InvalidEmailFormatException("Email format not supported");
        }

        Optional<UserEntity> client = userDao.findByEmail(userCredential.getEmail());

        if (!(client.isPresent())) {
            logger.error("Client not found!");
            throw new EntityNotFoundException("Client not found!");
        }

        Matcher matcher = Pattern.compile(PASSWORD_PATTERN).matcher(userCredential.getPassword());
        if (!(matcher.matches())) {
            logger.error("Invalid password format!");
            throw new InvalidPasswordFormatException("Invalid password format!");
        }


        String password = PasswordEncoder.decrypt(client.get().getUserCredentials().getPassword());
        if (!(password.equals(userCredential.getPassword()))) {
            logger.error("Incorrect email or password!");
            throw new IncorrectEmailOrPasswordException("Incorrect email or password!");
        }
    }
}
