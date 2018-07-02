package exceptions;

public class InvalidDateException extends Throwable {

    public InvalidDateException() {
        super("Invalid date.");
    }
}
