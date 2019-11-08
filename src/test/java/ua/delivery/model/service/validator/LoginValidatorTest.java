package ua.delivery.model.service.validator;

import org.junit.Test;
import ua.delivery.model.domain.UserCredentials;
import ua.delivery.model.exception.EntityNotFoundException;
import ua.delivery.model.exception.InvalidCredentialsException;

import static org.junit.Assert.*;

public class LoginValidatorTest {
    private final LoginValidator loginValidator = new LoginValidator();

    @Test
    public void validate_usualBehaviour() {
        UserCredentials userCredentials = new UserCredentials("ivan@mail.com", "Qwerty123#");
        loginValidator.validate(userCredentials);
    }

    @Test(expected = EntityNotFoundException.class)
    public void validate_shouldThrowEntityException() {
        loginValidator.validate(null);
    }

    @Test(expected = InvalidCredentialsException.class)
    public void validate_shouldThrowInvalidEmail() {
        UserCredentials userCredentials = new UserCredentials("asdf", "Qwerty123#");
        loginValidator.validate(userCredentials);
    }

    @Test(expected = InvalidCredentialsException.class)
    public void validate_shouldThrowInvalidPassword() {
        UserCredentials userCredentials = new UserCredentials("ivan@mail.com", "123");
        loginValidator.validate(userCredentials);
    }
}