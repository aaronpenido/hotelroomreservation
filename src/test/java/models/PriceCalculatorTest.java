package models;

import enums.CustomerType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import readers.CustomerTypeReader;
import readers.DateReader;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PriceCalculatorTest {

    private final CustomerType regularCustomerType = CustomerType.REGULAR;
    private final CustomerType rewardsCustomerType = CustomerType.REWARDS;
    private final LocalDate weekDay = LocalDate.of(2018, 6, 19);
    private final LocalDate weekendDay = LocalDate.of(2018, 6, 17);

    private PriceCalculator priceCalculator;

    private PriceQuote priceQuote;

    @Mock
    private Hotel hotel;

    @Mock
    private CustomerTypeReader customerTypeReader;

    @Mock
    private DateReader dateReader;

    @Before
    public void setUp() {
        priceQuote = new PriceQuote(customerTypeReader, dateReader);
        priceCalculator = new PriceCalculator(hotel, priceQuote);
    }

    @Test
    public void weekDayCostsForRegularCustomer() {
        BigDecimal expectedValue = BigDecimal.valueOf(10L);

        when(customerTypeReader.read()).thenReturn(regularCustomerType);
        when(dateReader.read()).thenReturn(Collections.singletonList(weekDay));
        when(hotel.getWeekDayPriceForRegularCustomer()).thenReturn(expectedValue);

        BigDecimal price = priceCalculator.calculate();

        assertThat(price).isEqualTo(expectedValue);
    }

    @Test
    public void weekDayCostsForRewardsCustomer() {
        BigDecimal expectedValue = BigDecimal.valueOf(20L);

        when(customerTypeReader.read()).thenReturn(rewardsCustomerType);
        when(dateReader.read()).thenReturn(Collections.singletonList(weekDay));
        when(hotel.getWeekDayPriceForRewardsCustomer()).thenReturn(expectedValue);

        BigDecimal price = priceCalculator.calculate();

        assertThat(price).isEqualTo(expectedValue);
    }

    @Test
    public void weekendDayCostsForRegularCustomer() {
        BigDecimal expectedValue = BigDecimal.valueOf(30L);

        when(customerTypeReader.read()).thenReturn(regularCustomerType);
        when(dateReader.read()).thenReturn(Collections.singletonList(weekendDay));
        when(hotel.getWeekendDayPriceForRegularCustomer()).thenReturn(expectedValue);


        BigDecimal price = priceCalculator.calculate();

        assertThat(price).isEqualTo(expectedValue);
    }

    @Test
    public void weekendDayCostsForRewardsCustomer() {
        BigDecimal expectedValue = BigDecimal.valueOf(40L);

        when(customerTypeReader.read()).thenReturn(rewardsCustomerType);
        when(dateReader.read()).thenReturn(Collections.singletonList(weekendDay));
        when(hotel.getWeekendDayPriceForRewardsCustomer()).thenReturn(expectedValue);

        BigDecimal price = priceCalculator.calculate();

        assertThat(price).isEqualTo(expectedValue);
    }

    @Test
    public void weekDayAndWeekendDayCostsForRegularCustomer() {
        BigDecimal weekDayValue = BigDecimal.valueOf(40L);
        BigDecimal weekendDayValue = BigDecimal.valueOf(60L);
        BigDecimal expectedValue = BigDecimal.valueOf(100L);

        when(customerTypeReader.read()).thenReturn(regularCustomerType);
        when(dateReader.read()).thenReturn(Arrays.asList(weekDay, weekendDay));
        when(hotel.getWeekDayPriceForRegularCustomer()).thenReturn(weekDayValue);
        when(hotel.getWeekendDayPriceForRegularCustomer()).thenReturn(weekendDayValue);

        BigDecimal price = priceCalculator.calculate();

        assertThat(price).isEqualTo(expectedValue);
    }

    @Test
    public void weekDayAndWeekendDayCostsForRewardsCustomer() {
        BigDecimal weekDayValue = BigDecimal.valueOf(40L);
        BigDecimal weekendDayValue = BigDecimal.valueOf(60L);
        BigDecimal expectedValue = BigDecimal.valueOf(100L);

        when(customerTypeReader.read()).thenReturn(rewardsCustomerType);
        when(dateReader.read()).thenReturn(Arrays.asList(weekDay, weekendDay));
        when(hotel.getWeekDayPriceForRewardsCustomer()).thenReturn(weekDayValue);
        when(hotel.getWeekendDayPriceForRewardsCustomer()).thenReturn(weekendDayValue);

        BigDecimal price = priceCalculator.calculate();

        assertThat(price).isEqualTo(expectedValue);
    }
}