package optional.exceptions;

public class NotACommandException extends Exception{
    public NotACommandException(String message) {
        super(message);
    }
}
