package exceptions;

public class InvalidCustomerTypeException extends RuntimeException {

    public InvalidCustomerTypeException() {
        super("Invalid customer type.");
    }
}
