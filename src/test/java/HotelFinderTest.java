import models.BridgewoodHotel;
import models.Hotel;
import models.LakewoodHotel;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import readers.CustomerTypeReader;
import readers.DateReader;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class HotelFinderTest {

    private HotelFinder hotelFinder;

    @Ignore
    @Test
    public void lakewoodIsTheCheapestHotelForRegularCustomerOnASingleWeekDay() {
        Hotel bestHotel = hotelFinder.findBestHotel();

        assertThat(bestHotel).isInstanceOf(LakewoodHotel.class);
    }

    @Ignore
    @Test
    public void bridgewoodIsTheCheapestHotelForRegularCustomerOnASingleWeekendDay() {
        Hotel bestHotel = hotelFinder.findBestHotel();

        assertThat(bestHotel).isInstanceOf(BridgewoodHotel.class);
    }
}