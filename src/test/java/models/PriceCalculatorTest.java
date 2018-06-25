package models;

import enums.CustomerType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PriceCalculatorTest {

    private PriceCalculator priceCalculator;

    @Mock
    private Hotel hotel;
    private CustomerType regularCustomerType = CustomerType.REGULAR;
    private CustomerType rewardsCustomerType = CustomerType.REWARDS;
    private LocalDate weekDay = LocalDate.of(2018, 6, 19);
    private LocalDate weekendDay = LocalDate.of(2018, 6, 17);

    @Before
    public void setUp() {
        priceCalculator = new PriceCalculator(hotel);
    }

    @Test
    public void weekDayCostsForRegularCustomer() {
        BigDecimal expectedValue = BigDecimal.valueOf(10L);

        when(hotel.getWeekDayPriceForRegularCustomer()).thenReturn(expectedValue);

        BigDecimal price = priceCalculator.calculate(weekDay, regularCustomerType);

        assertThat(price).isEqualTo(expectedValue);
    }

    @Test
    public void wekDayCostsForRewardsCustomer() {
        BigDecimal expectedValue = BigDecimal.valueOf(20L);

        when(hotel.getWeekDayPriceForRewardsCustomer()).thenReturn(expectedValue);

        BigDecimal price = priceCalculator.calculate(weekDay, rewardsCustomerType);

        assertThat(price).isEqualTo(expectedValue);
    }

    @Test
    public void weekendDayCostsForRegularCustomer() {
        BigDecimal expectedValue = BigDecimal.valueOf(30L);

        when(hotel.getWeekendDayPriceForRegularCustomer()).thenReturn(expectedValue);

        BigDecimal price = priceCalculator.calculate(weekendDay, regularCustomerType);

        assertThat(price).isEqualTo(expectedValue);
    }

    @Test
    public void weekendDayCostsForRewardsCustomer() {
        BigDecimal expectedValue = BigDecimal.valueOf(40L);

        when(hotel.getWeekendDayPriceForRewardsCustomer()).thenReturn(expectedValue);

        BigDecimal price = priceCalculator.calculate(weekendDay, rewardsCustomerType);

        assertThat(price).isEqualTo(expectedValue);
    }
}