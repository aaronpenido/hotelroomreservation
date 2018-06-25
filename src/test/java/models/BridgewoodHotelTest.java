package models;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgewoodHotelTest {

    BridgewoodHotel bridgewoodHotel;

    @Before
    public void setUp() {
        bridgewoodHotel = new BridgewoodHotel();
    }

    @Test
    public void ratingIsEqualsTo4() {
        assertThat(bridgewoodHotel.getRating()).isEqualTo(4);
    }

    @Test
    public void weekDayCosts160ForRegularCustomer() {
        BigDecimal price = bridgewoodHotel.getWeekDayPriceForRegularCustomer();

        assertThat(price.intValue()).isEqualTo(160);
    }

    @Test
    public void weekDayCosts110ForRewardsCustomer() {
        BigDecimal price = bridgewoodHotel.getWeekDayPriceForRewardsCustomer();

        assertThat(price.intValue()).isEqualTo(110);
    }

    @Test
    public void weekendDayCosts60ForRegularCustomer() {
        BigDecimal price = bridgewoodHotel.getWeekendDayPriceForRegularCustomer();

        assertThat(price.intValue()).isEqualTo(60);
    }

    @Test
    public void weekendDayCosts50ForRewardsCustomer() {
        BigDecimal price = bridgewoodHotel.getWeekendDayPriceForRewardsCustomer();

        assertThat(price.intValue()).isEqualTo(50);
    }
}