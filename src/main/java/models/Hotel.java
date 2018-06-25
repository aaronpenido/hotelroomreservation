package models;

import java.math.BigDecimal;

public interface Hotel {

    int getRating();
    BigDecimal getWeekDayPriceForRegularCustomer();
    BigDecimal getWeekDayPriceForRewardsCustomer();
    BigDecimal getWeekendDayPriceForRegularCustomer();
    BigDecimal getWeekendDayPriceForRewardsCustomer();
}
