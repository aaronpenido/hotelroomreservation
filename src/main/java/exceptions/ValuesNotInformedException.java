package exceptions;

public class ValuesNotInformedException extends RuntimeException {

    public ValuesNotInformedException() {
        super("Please inform customer type and dates");
    }
}
