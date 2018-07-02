package readers;

import exceptions.InvalidDateException;
import models.io.IOReader;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateReader {

    private IOReader ioReader;

    public DateReader(IOReader ioReader) {
        this.ioReader = ioReader;
    }

    public LocalDate read() throws InvalidDateException {
        String date = ioReader.read();

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyy(EEE)", Locale.ENGLISH);
            return LocalDate.parse(date, formatter);
        } catch (Exception exception) {
            throw new InvalidDateException();
        }
    }
}
