import models.Hotel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import readers.CustomerTypeInputReader;
import readers.DateReader;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class HotelFinderTest {

    private HotelFinder hotelFinder;
    @Mock
    private CustomerTypeInputReader customerTypeInputReader;
    @Mock
    private DateReader dateReader;

    @Test
    public void findBestHotel() {
        hotelFinder = new HotelFinder(customerTypeInputReader, dateReader);

        Hotel bestHotel = hotelFinder.findBestHotel();

        assertThat(bestHotel).isNotNull();
    }
}