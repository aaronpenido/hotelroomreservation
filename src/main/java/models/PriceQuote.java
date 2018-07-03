package models;

import enums.CustomerType;

import java.time.LocalDate;
import java.util.List;

public class PriceQuote {

    private final LocalDate date;
    private final CustomerType customerType;

    public PriceQuote(LocalDate date, CustomerType customerType) {
        this.date = date;
        this.customerType = customerType;
    }

    public LocalDate getDate() {
        return date;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }
}
