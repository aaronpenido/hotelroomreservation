package models;

import java.math.BigDecimal;

public class BridgewoodHotel implements Hotel {

    @Override
    public int getRating() {
        return 4;
    }

    @Override
    public BigDecimal getWeekDayPriceForRegularCustomer() {
        return BigDecimal.valueOf(160l);
    }

    @Override
    public BigDecimal getWeekDayPriceForRewardsCustomer() {
        return BigDecimal.valueOf(110l);
    }

    @Override
    public BigDecimal getWeekendDayPriceForRegularCustomer() {
        return BigDecimal.valueOf(60l);
    }

    @Override
    public BigDecimal getWeekendDayPriceForRewardsCustomer() {
        return BigDecimal.valueOf(50l);
    }
}
