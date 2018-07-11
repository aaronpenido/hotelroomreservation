import enums.CustomerType;
import models.Date;
import models.Hotel;
import models.PriceQuote;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HotelFinderTest {

    private HotelFinder hotelFinder;

    @Mock
    private Hotel cheaperHotel;
    @Mock
    private Hotel moreExpensiveHotel;
    @Mock
    private PriceQuote priceQuote;
    @Mock
    private Date weekDate;
    @Mock
    private Date weekendDate;

    private BigDecimal cheaperPrice = BigDecimal.ONE;
    private BigDecimal moreExpensivePrice = BigDecimal.TEN;

    @Before
    public void setUp() {
        when(weekDate.isWeekendDay()).thenReturn(false);
        when(weekendDate.isWeekendDay()).thenReturn(true);
    }

    @Test
    public void weekDayPriceForRegularCustomer() {
        when(cheaperHotel.getWeekDayPriceForRegularCustomer()).thenReturn(cheaperPrice);
        when(moreExpensiveHotel.getWeekDayPriceForRegularCustomer()).thenReturn(moreExpensivePrice);

        mockPriceQuoteWithWeekDayAndRegularCustomer();

        hotelFinder = new HotelFinder(Arrays.asList(cheaperHotel, moreExpensiveHotel), priceQuote);

        Hotel bestHotel = hotelFinder.findBestHotel();

        assertThat(bestHotel).isEqualTo(cheaperHotel);
    }

    @Test
    public void weekendDayPriceForRegularCustomer() {
        when(cheaperHotel.getWeekendDayPriceForRegularCustomer()).thenReturn(cheaperPrice);
        when(moreExpensiveHotel.getWeekendDayPriceForRegularCustomer()).thenReturn(moreExpensivePrice);

        mockPriceQuotWithWeekendDayAndRegularCustomer();

        hotelFinder = new HotelFinder(Arrays.asList(cheaperHotel, moreExpensiveHotel), priceQuote);

        Hotel bestHotel = hotelFinder.findBestHotel();

        assertThat(bestHotel).isEqualTo(cheaperHotel);
    }

    @Test
    public void weekDayPriceForRewardsCustomer() {
        when(cheaperHotel.getWeekDayPriceForRewardsCustomer()).thenReturn(cheaperPrice);
        when(moreExpensiveHotel.getWeekDayPriceForRewardsCustomer()).thenReturn(moreExpensivePrice);

        mockPriceQuoteWithWeekDayAndRewardsCustomer();

        hotelFinder = new HotelFinder(Arrays.asList(cheaperHotel, moreExpensiveHotel), priceQuote);

        Hotel bestHotel = hotelFinder.findBestHotel();

        assertThat(bestHotel).isEqualTo(cheaperHotel);
    }

    @Test
    public void weekendDayPriceForRewardsCustomer() {
        when(cheaperHotel.getWeekendDayPriceForRewardsCustomer()).thenReturn(cheaperPrice);
        when(moreExpensiveHotel.getWeekendDayPriceForRewardsCustomer()).thenReturn(moreExpensivePrice);

        mockPriceQuotWithWeekendDayAndRewardsCustomer();

        hotelFinder = new HotelFinder(Arrays.asList(cheaperHotel, moreExpensiveHotel), priceQuote);

        Hotel bestHotel = hotelFinder.findBestHotel();

        assertThat(bestHotel).isEqualTo(cheaperHotel);
    }

    @Test
    public void datesForRegularCustomer() {
        List<Date> dates = Arrays.asList(weekDate, weekendDate);

        when(priceQuote.getDates()).thenReturn(dates);
        when(priceQuote.getCustomerType()).thenReturn(CustomerType.REGULAR);

        BigDecimal cheaperWeekDayPrice = BigDecimal.valueOf(100L);
        BigDecimal cheaperWeekendDayPrice = BigDecimal.valueOf(175L);
        BigDecimal moreExpensiveWeekDayPrice = BigDecimal.valueOf(200L);
        BigDecimal moreExpensiveWeekendDayPrice = BigDecimal.valueOf(250L);

        when(cheaperHotel.getWeekDayPriceForRegularCustomer()).thenReturn(cheaperWeekDayPrice);
        when(cheaperHotel.getWeekendDayPriceForRegularCustomer()).thenReturn(moreExpensiveWeekendDayPrice);

        when(moreExpensiveHotel.getWeekDayPriceForRegularCustomer()).thenReturn(moreExpensiveWeekDayPrice);
        when(moreExpensiveHotel.getWeekendDayPriceForRegularCustomer()).thenReturn(cheaperWeekendDayPrice);

        hotelFinder = new HotelFinder(Arrays.asList(cheaperHotel, moreExpensiveHotel), priceQuote);

        Hotel bestHotel = hotelFinder.findBestHotel();

        assertThat(bestHotel).isEqualTo(cheaperHotel);
    }

    private void mockPriceQuoteWithWeekDayAndRegularCustomer() {
        mockPriceQuote(weekDate, CustomerType.REGULAR);
    }

    private void mockPriceQuotWithWeekendDayAndRegularCustomer() {
        mockPriceQuote(weekendDate, CustomerType.REGULAR);
    }

    private void mockPriceQuoteWithWeekDayAndRewardsCustomer() {
        mockPriceQuote(weekDate, CustomerType.REWARDS);
    }

    private void mockPriceQuotWithWeekendDayAndRewardsCustomer() {
        mockPriceQuote(weekendDate, CustomerType.REWARDS);
    }

    private void mockPriceQuote(Date date, CustomerType customerType) {
        when(priceQuote.getDates()).thenReturn(Collections.singletonList(date));
        when(priceQuote.getCustomerType()).thenReturn(customerType);
    }
}