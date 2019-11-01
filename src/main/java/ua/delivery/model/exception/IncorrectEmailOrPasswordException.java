package ua.delivery.model.exception;

public class IncorrectEmailOrPasswordException extends RuntimeException {
    public IncorrectEmailOrPasswordException(String message) {
        super(message);
    }

    public IncorrectEmailOrPasswordException(String message, Throwable cause) {
        super(message, cause);
    }
}
