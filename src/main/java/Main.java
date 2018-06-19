import models.Hotel;
import readers.CustomerTypeInputReader;
import readers.DateReader;
import writers.OutputWriter;

public class Main {

    public static void main(String[] args)  {
        CustomerTypeInputReader customerTypeInputReader = new CustomerTypeInputReader();
        DateReader dateReader = new DateReader();
        OutputWriter outputWriter = new OutputWriter();

        HotelFinder hotelFinder = new HotelFinder(customerTypeInputReader, dateReader);
        Hotel bestHotel = hotelFinder.findBestHotel();

        outputWriter.write(bestHotel);
    }
}
