package models;

import java.math.BigDecimal;

public class LakewoodHotel implements Hotel {

    @Override
    public int getRating() {
        return 3;
    }

    @Override
    public BigDecimal getWeekDayPriceForRegularCustomer() {
        return BigDecimal.valueOf(110l);
    }

    @Override
    public BigDecimal getWeekDayPriceForRewardsCustomer() {
        return BigDecimal.valueOf(80l);
    }

    @Override
    public BigDecimal getWeekendDayPriceForRegularCustomer() {
        return BigDecimal.valueOf(90l);
    }

    @Override
    public BigDecimal getWeekendDayPriceForRewardsCustomer() {
        return BigDecimal.valueOf(80l);
    }
}
