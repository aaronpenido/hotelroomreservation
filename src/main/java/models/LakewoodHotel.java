package models;

import enums.CustomerType;
import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class LakewoodHotel implements Hotel {

    @Override
    public int getRating() {
        return 3;
    }

    @Override
    public BigDecimal getPrice(LocalDate localDate, CustomerType customerType) {
        if (customerType.equals(CustomerType.REGULAR)) {
            if (isWeekendDay(localDate)) {
                return BigDecimal.valueOf(90l);
            }
            return BigDecimal.valueOf(110l);
        }

        return BigDecimal.valueOf(80l);
    }

    private boolean isWeekendDay(LocalDate localDate) {
        return localDate.getDayOfWeek().equals(DayOfWeek.SATURDAY) ||
                localDate.getDayOfWeek().equals(DayOfWeek.SUNDAY);
    }
}
