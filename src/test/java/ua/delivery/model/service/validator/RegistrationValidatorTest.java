package ua.delivery.model.service.validator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ua.delivery.model.domain.Role;
import ua.delivery.model.domain.User;
import ua.delivery.model.domain.UserCredentials;
import ua.delivery.model.exception.EntityNotFoundException;
import ua.delivery.model.exception.InvalidCredentialsException;

import static org.junit.Assert.*;

public class RegistrationValidatorTest {
    private static final Long ID = 0L;

    private static final String NAME = "Ivan";

    private static final String SURNAME = "Popov";

    private static final String EMAIL = "Ivan@mail.com";

    private static final String PASSWORD = "Qwerty123#";

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private final RegistrationValidator registrationValidator = new RegistrationValidator();

    private User getUser(String email, String password) {
        return User.builder()
                .withId(ID)
                .withName(NAME)
                .withSurname(SURNAME)
                .withUserCredentials(new UserCredentials(email, password))
                .withRole(Role.USER)
                .build();
    }

    @Test
    public void validateNormalBehaviour() {
        registrationValidator.validate(getUser(EMAIL, PASSWORD));
    }

    @Test
    public void validateNullPassed() {
        exception.expect(EntityNotFoundException.class);
        registrationValidator.validate(null);
    }

    @Test
    public void validateShouldThrowDueToWrongEmail() {
        exception.expect(InvalidCredentialsException.class);
        registrationValidator.validate(getUser("123", PASSWORD));
    }

    @Test
    public void validateShouldThrowDueToWrongPassword() {
        exception.expect(InvalidCredentialsException.class);
        registrationValidator.validate(getUser(EMAIL, "123"));
    }

}