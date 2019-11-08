package ua.delivery.model.service.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.delivery.model.domain.User;
import ua.delivery.model.domain.UserCredentials;
import ua.delivery.model.exception.EntityNotFoundException;
import ua.delivery.model.exception.InvalidCredentialsException;

import java.util.Objects;

public class RegistrationValidator implements Validator<User> {
    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationValidator.class);

    private static final String EMAIL_REGEX = "^(.+)@(.+)$";
    private static final String PASSWORD_REGEX = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";


    public RegistrationValidator() {
    }

    @Override
    public void validate(User user) {
        UserCredentials userCredential = user.getUserCredentials();

        if (Objects.isNull(userCredential)) {
            LOGGER.warn("Provided credentials are null" );
            throw new EntityNotFoundException("Provided object is null!");
        }

        if (!userCredential.getEmail().matches(EMAIL_REGEX)) {
            LOGGER.warn("Provided email " + userCredential.getEmail() + " does not match regex");
            throw new InvalidCredentialsException("Email format not supported");
        }

        if (!userCredential.getPassword().matches(PASSWORD_REGEX)) {
            throw new InvalidCredentialsException("Password format not supported");
        }
    }
}
