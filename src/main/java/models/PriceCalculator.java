package models;

import enums.CustomerType;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class PriceCalculator {

    private Hotel hotel;
    private PriceQuote priceQuote;

    public PriceCalculator(Hotel hotel, PriceQuote priceQuote) {
        this.hotel = hotel;
        this.priceQuote = priceQuote;
    }

    public BigDecimal calculate() {
        if (isWeekendDay(priceQuote.getDate())) {
            return getWeekendDayPrice(priceQuote.getCustomerType());
        }

        return getWeekDayPrice(priceQuote.getCustomerType());
    }

    private BigDecimal getWeekDayPrice(CustomerType customerType) {
        if (customerType.equals(CustomerType.REGULAR)) {
            return hotel.getWeekDayPriceForRegularCustomer();
        }

        return hotel.getWeekDayPriceForRewardsCustomer();
    }

    private BigDecimal getWeekendDayPrice(CustomerType customerType) {
        if (customerType.equals(CustomerType.REGULAR)) {
            return hotel.getWeekendDayPriceForRegularCustomer();
        }
        return hotel.getWeekendDayPriceForRewardsCustomer();
    }

    private boolean isWeekendDay(LocalDate localDate) {
        return localDate.getDayOfWeek().equals(DayOfWeek.SATURDAY) ||
                localDate.getDayOfWeek().equals(DayOfWeek.SUNDAY);
    }
}
