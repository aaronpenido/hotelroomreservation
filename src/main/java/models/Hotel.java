package models;

import enums.CustomerType;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Hotel {

    int getRating();

    BigDecimal getPrice(LocalDate localDate, CustomerType customerType);
}
