package models;

import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

public class DateTest {

    @Test
    public void createNewDateFromStringAndFormatter() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyy(EEE)", Locale.ENGLISH);
        String dateStr = "03Jul2018(Tue)";
        LocalDate expectedDate = LocalDate.of(2018, 7, 3);

        Date date = new Date(dateStr, formatter);

        assertThat(date.getLocalDate()).isEqualTo(expectedDate);
    }

    @Test
    public void isWeekendDay() {
        LocalDate weekendDate = LocalDate.of(2018, 7, 1);

        Date date = new Date(weekendDate);

        assertThat(date.isWeekendDay()).isTrue();
    }

    @Test
    public void isWeekDay() {
        LocalDate weekDate = LocalDate.of(2018, 7, 3);

        Date date = new Date(weekDate);

        assertThat(date.isWeekendDay()).isFalse();
    }
}