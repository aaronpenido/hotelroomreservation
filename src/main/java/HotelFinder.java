import models.Hotel;
import models.PriceCalculator;
import models.PriceQuote;

import java.math.BigDecimal;
import java.util.List;

public class HotelFinder {

    private List<Hotel> hotels;
    private PriceQuote priceQuote;

    public HotelFinder(List<Hotel> hotels, PriceQuote priceQuote) {
        this.hotels = hotels;
        this.priceQuote = priceQuote;
    }

    public Hotel findBestHotel() {
        Hotel bestHotel = null;

        for (Hotel hotel : hotels) {
            if (bestHotel == null) {
                bestHotel = hotel;
            } else {
                bestHotel = getBestHotel(bestHotel, hotel);
            }
        }

        return bestHotel;
    }

    private Hotel getBestHotel(Hotel bestHotel, Hotel hotel) {
        BigDecimal hotelPrice = calculateHotelPrice(hotel);
        BigDecimal bestHotelPrice = calculateHotelPrice(bestHotel);

        if (isPriceEquals(hotelPrice, bestHotelPrice)) {
            if(isRatingGreater(hotel.getRating(), bestHotel.getRating())) {
                bestHotel = hotel;
            }
        } else if (isPriceMinor(hotelPrice, bestHotelPrice)) {
            bestHotel = hotel;
        }
        return bestHotel;
    }

    private boolean isRatingGreater(int r1, int r2) {
        return r1 > r2;
    }

    private boolean isPriceEquals(BigDecimal p1, BigDecimal p2) {
        return p1.compareTo(p2) == 0;
    }

    private boolean isPriceMinor(BigDecimal p1, BigDecimal p2) {
        return p1.compareTo(p2) < 0;
    }

    private BigDecimal calculateHotelPrice(Hotel hotel) {
        PriceCalculator priceCalculator = new PriceCalculator(hotel, priceQuote);

        return priceCalculator.calculate();
    }
}
