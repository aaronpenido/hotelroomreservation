package models;

import enums.CustomerType;
import readers.CustomerTypeReader;
import readers.DateReader;
import java.util.List;

public class PriceQuote {

    private final CustomerType customerType;
    private final List<Date> dates;

    public PriceQuote(CustomerTypeReader customerTypeReader, DateReader dateReader) {
        this.customerType = customerTypeReader.read();
        this.dates = dateReader.read();
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public List<Date> getDates() {
        return dates;
    }
}
