package models;

import org.junit.Before;
import org.junit.Test;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class RidgewoodHotelTest {

    RidgewoodHotel ridgewoodHotel;

    @Before
    public void setUp() {
        ridgewoodHotel = new RidgewoodHotel();
    }

    @Test
    public void ratingIsEqualsTo5() {
        assertThat(ridgewoodHotel.getRating()).isEqualTo(5);
    }

    @Test
    public void weekDayCosts220ForRegularCustomer() {
        BigDecimal price = ridgewoodHotel.getWeekDayPriceForRegularCustomer();

        assertThat(price.intValue()).isEqualTo(220);
    }

    @Test
    public void weekDayCosts100ForRewardsCustomer() {
        BigDecimal price = ridgewoodHotel.getWeekDayPriceForRewardsCustomer();

        assertThat(price.intValue()).isEqualTo(100);
    }

    @Test
    public void weekendDayCosts150ForRegularCustomer() {
        BigDecimal price = ridgewoodHotel.getWeekendDayPriceForRegularCustomer();

        assertThat(price.intValue()).isEqualTo(150);
    }

    @Test
    public void weekendDayCosts40ForRewardsCustomer() {
        BigDecimal price = ridgewoodHotel.getWeekendDayPriceForRewardsCustomer();

        assertThat(price.intValue()).isEqualTo(40);
    }
}