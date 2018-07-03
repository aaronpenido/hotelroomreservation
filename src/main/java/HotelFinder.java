import enums.CustomerType;
import models.PriceQuote;
import models.Hotel;
import models.LakewoodHotel;
import models.PriceCalculator;
import readers.CustomerTypeReader;
import readers.DateReader;

import java.time.LocalDate;
import java.util.List;

public class HotelFinder {

    public Hotel findBestHotel() {
        return new LakewoodHotel();
    }
}
