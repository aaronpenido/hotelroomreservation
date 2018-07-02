package readers;

import enums.CustomerType;
import exceptions.InvalidCustomerTypeException;
import models.io.IOReader;

public class CustomerTypeReader {

    private IOReader ioReader;

    public CustomerTypeReader(IOReader ioReader) {
        this.ioReader = ioReader;
    }

    public CustomerType read() throws InvalidCustomerTypeException {
        String customerType = ioReader.read();

        try {
            return CustomerType.valueOf(customerType.toUpperCase());
        } catch(Exception exception) {
            throw new InvalidCustomerTypeException();
        }
    }
}
