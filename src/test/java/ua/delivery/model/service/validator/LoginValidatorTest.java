package ua.delivery.model.service.validator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ua.delivery.model.domain.UserCredentials;
import ua.delivery.model.exception.EntityNotFoundException;
import ua.delivery.model.exception.InvalidCredentialsException;

public class LoginValidatorTest {
    private final LoginValidator loginValidator = new LoginValidator();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void validateUsualBehaviour() {
        UserCredentials userCredentials = new UserCredentials("ivan@mail.com", "Qwerty123#");
        loginValidator.validate(userCredentials);
    }

    @Test
    public void validateShouldThrowEntityException() {
        exception.expect(EntityNotFoundException.class);
        loginValidator.validate(null);
    }

    @Test
    public void validateShouldThrowInvalidEmail() {
        exception.expect(InvalidCredentialsException.class);
        UserCredentials userCredentials = new UserCredentials("asdf", "Qwerty123#");
        loginValidator.validate(userCredentials);
    }

    @Test
    public void validateShouldThrowInvalidPassword() {
        exception.expect(InvalidCredentialsException.class);
        UserCredentials userCredentials = new UserCredentials("ivan@mail.com", "123");
        loginValidator.validate(userCredentials);
    }
}