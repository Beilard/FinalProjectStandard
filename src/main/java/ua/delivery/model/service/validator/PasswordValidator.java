package ua.delivery.model.service.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator<E> implements Validator<String> {
    private Pattern pattern;
    private Matcher matcher;

    private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
    private Logger logger = LoggerFactory.getLogger("PasswordValidator.class");

    public PasswordValidator() {
        pattern = Pattern.compile(PASSWORD_PATTERN);
    }

    @Override
    public void validate(String item) {
        matcher = pattern.matcher(item);
        if (!(matcher.matches())) {
            logger.error("Invalid password format!");
            throw new RuntimeException("Invalid password format!");
        }
    }

}
