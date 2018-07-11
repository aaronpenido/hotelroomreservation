package readers;

import enums.CustomerType;
import exceptions.InvalidCustomerTypeException;
import models.io.IOReader;

public class CommandLineCustomerTypeReader implements CustomerTypeReader {

    private IOReader ioReader;

    public CommandLineCustomerTypeReader(IOReader ioReader) {
        this.ioReader = ioReader;
    }

    @Override
    public CustomerType read() throws InvalidCustomerTypeException {
        try {
            String customerType = ioReader.read();
            return CustomerType.valueOf(customerType.toUpperCase());
        } catch(Exception exception) {
            throw new InvalidCustomerTypeException();
        }
    }
}
