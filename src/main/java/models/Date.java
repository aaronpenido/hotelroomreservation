package models;

import exceptions.InvalidDateException;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public class Date {

    private LocalDate localDate;

    public Date(LocalDate localDate) {
        this.localDate = localDate;
    }

    public Date(String date, DateTimeFormatter formatter) {
        this.localDate = parseDate(date, formatter);
    }

    private LocalDate parseDate(String date, DateTimeFormatter formatter) {
        try {
            return LocalDate.parse(date, formatter);
        } catch (DateTimeParseException dateTimeParseException) {
            throw new InvalidDateException();
        }
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public boolean isWeekendDay() {
        return localDate.getDayOfWeek().equals(DayOfWeek.SATURDAY) ||
                localDate.getDayOfWeek().equals(DayOfWeek.SUNDAY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Date date = (Date) o;
        return Objects.equals(localDate, date.localDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(localDate);
    }
}
