import models.Hotel;
import models.io.ConsoleReader;
import models.io.ConsoleWriter;
import models.io.IOReader;
import models.io.IOWriter;
import readers.CustomerTypeReader;
import readers.DateReader;
import writers.OutputWriter;

public class Main {

    public static void main(String[] args)  {
        IOReader ioReader = new ConsoleReader();
        IOWriter ioWriter = new ConsoleWriter();

        CustomerTypeReader customerTypeInputReader = new CustomerTypeReader(ioReader);
        DateReader dateReader = new DateReader(ioReader);

        OutputWriter outputWriter = new OutputWriter(ioWriter);

        HotelFinder hotelFinder = new HotelFinder();
        Hotel bestHotel = hotelFinder.findBestHotel();

        outputWriter.write(bestHotel);
    }
}
