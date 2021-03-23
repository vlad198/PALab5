package optional.exceptions;

public class NotEnoughArguments extends RuntimeException{
    public NotEnoughArguments(String message) {
        super(message);
    }
}
