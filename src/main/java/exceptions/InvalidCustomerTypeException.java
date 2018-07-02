package exceptions;

public class InvalidCustomerTypeException extends Throwable {

    public InvalidCustomerTypeException() {
        super("Invalid customer type.");
    }
}
