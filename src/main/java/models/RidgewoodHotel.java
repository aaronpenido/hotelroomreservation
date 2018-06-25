package models;

import java.math.BigDecimal;

public class RidgewoodHotel implements Hotel {

    @Override
    public int getRating() {
        return 5;
    }

    @Override
    public BigDecimal getWeekDayPriceForRegularCustomer() {
        return BigDecimal.valueOf(220l);
    }

    @Override
    public BigDecimal getWeekDayPriceForRewardsCustomer() {
        return BigDecimal.valueOf(100l);
    }

    @Override
    public BigDecimal getWeekendDayPriceForRegularCustomer() {
        return BigDecimal.valueOf(150l);
    }

    @Override
    public BigDecimal getWeekendDayPriceForRewardsCustomer() {
        return BigDecimal.valueOf(40l);
    }
}
