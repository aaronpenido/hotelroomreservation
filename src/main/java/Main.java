import models.Hotel;
import models.io.ConsoleReader;
import models.io.IOReader;
import readers.CustomerTypeReader;
import readers.DateReader;
import writers.OutputWriter;

public class Main {

    public static void main(String[] args)  {
        IOReader ioReader = new ConsoleReader();
        CustomerTypeReader customerTypeInputReader = new CustomerTypeReader(ioReader);
        DateReader dateReader = new DateReader(ioReader);
        OutputWriter outputWriter = new OutputWriter();

        HotelFinder hotelFinder = new HotelFinder(customerTypeInputReader, dateReader);
        Hotel bestHotel = hotelFinder.findBestHotel();

        outputWriter.write(bestHotel);
    }
}
