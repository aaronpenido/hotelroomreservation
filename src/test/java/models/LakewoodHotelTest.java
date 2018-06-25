package models;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class LakewoodHotelTest {

    LakewoodHotel lakewoodHotel;

    @Before
    public void setUp() {
        lakewoodHotel = new LakewoodHotel();
    }

    @Test
    public void ratingIsEqualsTo3() {
        assertThat(lakewoodHotel.getRating()).isEqualTo(3);
    }

    @Test
    public void weekDayCosts110ForRegularCustomer() {
        BigDecimal price = lakewoodHotel.getWeekDayPriceForRegularCustomer();

        assertThat(price.intValue()).isEqualTo(110);
    }

    @Test
    public void weekDayCosts80ForRewardsCustomer() {
        BigDecimal price = lakewoodHotel.getWeekDayPriceForRewardsCustomer();

        assertThat(price.intValue()).isEqualTo(80);
    }

    @Test
    public void weekendDayCosts90ForRegularCustomer() {
        BigDecimal price = lakewoodHotel.getWeekendDayPriceForRegularCustomer();

        assertThat(price.intValue()).isEqualTo(90);
    }

    @Test
    public void weekendDayCosts80ForRewardsCustomer() {
        BigDecimal price = lakewoodHotel.getWeekendDayPriceForRewardsCustomer();

        assertThat(price.intValue()).isEqualTo(80);
    }
}