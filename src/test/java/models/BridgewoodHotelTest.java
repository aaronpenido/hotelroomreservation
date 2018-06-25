package models;


import enums.CustomerType;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgewoodHotelTest {

    BridgewoodHotel bridgewoodHotel;
    CustomerType regularCustomerType = CustomerType.REGULAR;
    CustomerType rewardsCustomerType = CustomerType.REWARDS;
    LocalDate weekDay = LocalDate.of(2018, 6, 19);
    LocalDate weekendDay = LocalDate.of(2018, 6, 17);

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
        BigDecimal price = bridgewoodHotel.getPrice(weekDay, regularCustomerType);

        assertThat(price.intValue()).isEqualTo(160);
    }

    @Test
    public void weekDayCosts110ForRewardsCustomer() {
        BigDecimal price = bridgewoodHotel.getPrice(weekDay, rewardsCustomerType);

        assertThat(price.intValue()).isEqualTo(110);
    }

    @Test
    public void weekendDayCosts60ForRegularCustomer() {
        BigDecimal price = bridgewoodHotel.getPrice(weekendDay, regularCustomerType);

        assertThat(price.intValue()).isEqualTo(60);
    }

    @Test
    public void weekendDayCosts50ForRewardsCustomer() {
        BigDecimal price = bridgewoodHotel.getPrice(weekendDay, rewardsCustomerType);

        assertThat(price.intValue()).isEqualTo(50);
    }
}