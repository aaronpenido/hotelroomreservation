import models.Hotel;
import models.LakewoodHotel;

public class HotelFinder {

    public Hotel findBestHotel() {
        return new LakewoodHotel();
    }
}
