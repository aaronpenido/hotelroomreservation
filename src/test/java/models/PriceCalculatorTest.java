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
        PriceQuote priceQuote = new PriceQuote(weekDay, regularCustomerType);

        when(hotel.getWeekDayPriceForRegularCustomer()).thenReturn(expectedValue);

        BigDecimal price = priceCalculator.calculate(priceQuote);

        assertThat(price).isEqualTo(expectedValue);
    }

    @Test
    public void wekDayCostsForRewardsCustomer() {
        BigDecimal expectedValue = BigDecimal.valueOf(20L);
        PriceQuote priceQuote = new PriceQuote(weekDay, rewardsCustomerType);

        when(hotel.getWeekDayPriceForRewardsCustomer()).thenReturn(expectedValue);

        BigDecimal price = priceCalculator.calculate(priceQuote);

        assertThat(price).isEqualTo(expectedValue);
    }

    @Test
    public void weekendDayCostsForRegularCustomer() {
        BigDecimal expectedValue = BigDecimal.valueOf(30L);
        PriceQuote priceQuote = new PriceQuote(weekendDay, regularCustomerType);

        when(hotel.getWeekendDayPriceForRegularCustomer()).thenReturn(expectedValue);

        BigDecimal price = priceCalculator.calculate(priceQuote);

        assertThat(price).isEqualTo(expectedValue);
    }

    @Test
    public void weekendDayCostsForRewardsCustomer() {
        BigDecimal expectedValue = BigDecimal.valueOf(40L);
        PriceQuote priceQuote = new PriceQuote(weekendDay, rewardsCustomerType);

        when(hotel.getWeekendDayPriceForRewardsCustomer()).thenReturn(expectedValue);

        BigDecimal price = priceCalculator.calculate(priceQuote);

        assertThat(price).isEqualTo(expectedValue);
    }
}