import models.Hotel;
import models.LakewoodHotel;
import readers.CustomerTypeReader;
import readers.DateReader;

public class HotelFinder {

    private CustomerTypeReader customerTypeInputReader;
    private DateReader dateReader;

    public HotelFinder(CustomerTypeReader customerTypeInputReader, DateReader dateReader) {
        this.customerTypeInputReader = customerTypeInputReader;
        this.dateReader = dateReader;
    }

    public Hotel findBestHotel() {
        return new LakewoodHotel();
    }
}
