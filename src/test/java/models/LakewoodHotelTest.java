package models;

import enums.CustomerType;
import org.junit.Before;
import org.junit.Test;
import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class LakewoodHotelTest {

    LakewoodHotel lakewoodHotel;
    CustomerType regularCustomerType = CustomerType.REGULAR;
    CustomerType rewardsCustomerType = CustomerType.REWARDS;
    LocalDate weekDay = LocalDate.of(2018, 6, 19);
    LocalDate weekendDay = LocalDate.of(2018, 6, 17);

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
        BigDecimal price = lakewoodHotel.getPrice(weekDay, regularCustomerType);

        assertThat(price.intValue()).isEqualTo(110);
    }

    @Test
    public void weekendDayCosts90ForRegularCustomer() {
        BigDecimal price = lakewoodHotel.getPrice(weekendDay, regularCustomerType);

        assertThat(price.intValue()).isEqualTo(90);
    }

    @Test
    public void weekDayCosts80ForRewardsCustomer() {
        BigDecimal price = lakewoodHotel.getPrice(weekDay, rewardsCustomerType);

        assertThat(price.intValue()).isEqualTo(80);
    }

    @Test
    public void weekendDayCosts80ForRegularCustomer() {
        BigDecimal price = lakewoodHotel.getPrice(weekendDay, rewardsCustomerType);

        assertThat(price.intValue()).isEqualTo(80);
    }
}