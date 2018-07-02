package writers;

import models.Hotel;
import models.io.IOWriter;

public class OutputWriter {

    private IOWriter ioWriter;

    public OutputWriter(IOWriter ioWriter) {
        this.ioWriter = ioWriter;
    }

    public void write(Hotel hotel) {
        ioWriter.write(hotel.getClass().getSimpleName());
    }
}
