import models.Hotel;
import models.LakewoodHotel;
import readers.CustomerTypeInputReader;
import readers.DateReader;

public class HotelFinder {

    private CustomerTypeInputReader customerTypeInputReader;
    private DateReader dateReader;

    public HotelFinder(CustomerTypeInputReader customerTypeInputReader, DateReader dateReader) {
        this.customerTypeInputReader = customerTypeInputReader;
        this.dateReader = dateReader;
    }

    public Hotel findBestHotel() {
        return new LakewoodHotel();
    }
}
