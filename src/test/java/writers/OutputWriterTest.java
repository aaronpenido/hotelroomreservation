package writers;

import models.BridgewoodHotel;
import models.Hotel;
import models.LakewoodHotel;
import models.RidgewoodHotel;
import models.io.IOWriter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class OutputWriterTest {

    OutputWriter outputWriter;

    @Mock
    private IOWriter ioWriter;

    @Before
    public void setUp() {
        outputWriter = new OutputWriter(ioWriter);
    }

    @Test
    public void writeBridgewoodHotelName() {
        Hotel hotel = new BridgewoodHotel();

        outputWriter.write(hotel);

        verify(ioWriter).write("BridgewoodHotel");
    }

    @Test
    public void writeRidgewoodHotelName() {
        Hotel hotel = new RidgewoodHotel();

        outputWriter.write(hotel);

        verify(ioWriter).write("RidgewoodHotel");
    }

    @Test
    public void writeLakewoodHotelName() {
        Hotel hotel = new LakewoodHotel();

        outputWriter.write(hotel);

        verify(ioWriter).write("LakewoodHotel");
    }
}