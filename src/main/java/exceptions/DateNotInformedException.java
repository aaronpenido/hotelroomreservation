package exceptions;

public class DateNotInformedException extends RuntimeException {

    public DateNotInformedException() {
        super("Date not informed.");
    }
}
