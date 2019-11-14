package ua.delivery.model.service.validator;

import org.apache.log4j.Logger;
import ua.delivery.model.domain.UserCredentials;
import ua.delivery.model.exception.EntityNotFoundException;
import ua.delivery.model.exception.InvalidCredentialsException;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginValidator implements Validator<UserCredentials> {
    private static final String EMAIL_REGEX = "^(.+)@(.+)$";
    private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

    private final static Logger LOGGER = Logger.getLogger("LoginValidator.class");

    public LoginValidator() {

    }

    @Override
    public void validate(UserCredentials userCredentials) {

        if (Objects.isNull(userCredentials)) {
            throw new EntityNotFoundException("Provided object is null!");
        }

        if (!userCredentials.getEmail().matches(EMAIL_REGEX)) {
            LOGGER.error("Email format not supported " + userCredentials.getEmail());
            throw new InvalidCredentialsException("Email format not supported");
        }

        Matcher matcher = Pattern.compile(PASSWORD_PATTERN).matcher(userCredentials.getPassword());
        if (!(matcher.matches())) {
            LOGGER.error("Invalid password format!");
            throw new InvalidCredentialsException("Invalid password format!");
        }



    }
}
