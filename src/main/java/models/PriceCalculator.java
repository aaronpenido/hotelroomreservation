package models;

import enums.CustomerType;

import java.math.BigDecimal;

public class PriceCalculator {

    private Hotel hotel;
    private PriceQuote priceQuote;

    public PriceCalculator(Hotel hotel, PriceQuote priceQuote) {
        this.hotel = hotel;
        this.priceQuote = priceQuote;
    }

    public BigDecimal calculate() {
        return priceQuote.getDates()
                .stream()
                .map(this::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal getPrice(Date date) {
        if (date.isWeekendDay()) {
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
}
