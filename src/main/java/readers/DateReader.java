package readers;

import exceptions.DateNotInformedException;
import exceptions.InvalidDateException;
import models.io.IOReader;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class DateReader {

    private IOReader ioReader;

    public DateReader(IOReader ioReader) {
        this.ioReader = ioReader;
    }

    public List<LocalDate> read() throws DateNotInformedException, InvalidDateException {
        String dates = readDates();
        throwDateNotInformedExceptionIfDatesAreNullOrEmpty(dates);
        List<String> dateList = dateListFromString(dates);

        return mapStringDatesToLocalDateList(dateList);
    }

    private String readDates() {
        return ioReader.read();
    }

    private void throwDateNotInformedExceptionIfDatesAreNullOrEmpty(String dates) {
        if (dates == null || dates.isEmpty()) {
            throw new DateNotInformedException();
        }
    }

    private List<String> dateListFromString(String dates) {
        String splitter = ",";
        return Arrays.asList(dates.split(splitter));
    }

    private List<LocalDate> mapStringDatesToLocalDateList(List<String> dateList) {
        return dateList
                .stream()
                .map(this::parseDate)
                .collect(Collectors.toList());
    }

    private LocalDate parseDate(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyy(EEE)", Locale.ENGLISH);
            return LocalDate.parse(date, formatter);
        } catch (Exception exception) {
            throw new InvalidDateException();
        }
    }
}
