package compulsory.exceptions;

public class NotABookException extends RuntimeException {
    public NotABookException(String message) {
        super(message);
    }
}
