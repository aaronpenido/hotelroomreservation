package models;

import enums.CustomerType;
import readers.CustomerTypeReader;
import readers.DateReader;
import java.util.List;

public class PriceQuote {

    private final CustomerTypeReader customerTypeReader;
    private final DateReader dateReader;

    public PriceQuote(CustomerTypeReader customerTypeReader, DateReader dateReader) {
        this.customerTypeReader = customerTypeReader;
        this.dateReader = dateReader;
    }

    public List<Date> getDates() {
        return dateReader.read();
    }

    public CustomerType getCustomerType() {
        return customerTypeReader.read();
    }
}
