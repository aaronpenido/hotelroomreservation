import models.BridgewoodHotel;
import models.Hotel;
import models.LakewoodHotel;
import models.PriceQuote;
import models.RidgewoodHotel;
import models.io.ConsoleReader;
import models.io.ConsoleWriter;
import models.io.IOReader;
import models.io.IOWriter;
import readers.CustomerTypeReader;
import readers.DateReader;
import writers.OutputWriter;

import java.util.Arrays;
import java.util.List;

public class HotelRoomReservation {

    private List<Hotel> hotels = Arrays.asList(new BridgewoodHotel(), new LakewoodHotel(), new RidgewoodHotel());
    private IOReader ioReader = new ConsoleReader();
    private CustomerTypeReader customerTypeReader = new CustomerTypeReader(ioReader);
    private DateReader dateReader = new DateReader(ioReader);
    private IOWriter ioWriter = new ConsoleWriter();

    public void findBestHotel() {
        PriceQuote priceQuote = new PriceQuote(customerTypeReader, dateReader);

        HotelFinder hotelFinder = new HotelFinder(hotels, priceQuote);

        Hotel bestHotel = hotelFinder.findBestHotel();

        writeBestHotel(bestHotel);
    }

    private void writeBestHotel(Hotel bestHotel) {
        OutputWriter outputWriter = new OutputWriter(ioWriter);
        outputWriter.write(bestHotel);
    }
}
