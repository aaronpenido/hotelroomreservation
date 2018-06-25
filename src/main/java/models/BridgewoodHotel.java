package models;

import enums.CustomerType;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class BridgewoodHotel implements Hotel {

    @Override
    public int getRating() {
        return 4;
    }

    @Override
    public BigDecimal getPrice(LocalDate localDate, CustomerType customerType) {
        if (customerType.equals(CustomerType.REGULAR)) {
            if (isWeekendDay(localDate)) {
                return BigDecimal.valueOf(60l);
            }
            return BigDecimal.valueOf(160l);
        }

        if (isWeekendDay(localDate)) {
            return BigDecimal.valueOf(50l);
        }

        return BigDecimal.valueOf(110l);
    }

    private boolean isWeekendDay(LocalDate localDate) {
        return localDate.getDayOfWeek().equals(DayOfWeek.SATURDAY) ||
                localDate.getDayOfWeek().equals(DayOfWeek.SUNDAY);
    }
}
