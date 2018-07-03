package readers;

import exceptions.DateNotInformedException;
import exceptions.InvalidDateException;
import models.io.IOReader;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DateReaderTest {

    private DateReader dateReader;

    @Mock
    private IOReader ioReader;

    @Before
    public void setUp() {
        dateReader = new DateReader(ioReader);
    }

    @Test
    public void readValidDates() {
        String validDates = "02Jul2018(Mon),03Jul2018(Tue)";
        List<LocalDate> expectedDates = Arrays.asList(
                LocalDate.of(2018, Month.JULY, 02),
                LocalDate.of(2018, Month.JULY, 03));

        when(ioReader.read()).thenReturn(validDates);

        List<LocalDate> dates = dateReader.read();

        assertThat(dates).isEqualTo(expectedDates);
    }

    @Test
    public void throwDateNotInformedExceptionWhenDateIsNull() {
        when(ioReader.read()).thenReturn(null);

        assertThatThrownBy(() -> dateReader.read())
                .isInstanceOf(DateNotInformedException.class);
    }

    @Test
    public void throwDateNotInformedExceptionWhenDateIsEmpty() {
        when(ioReader.read()).thenReturn("");

        assertThatThrownBy(() -> dateReader.read())
                .isInstanceOf(DateNotInformedException.class);
    }

    @Test
    public void throwInvalidDateExceptionWhenDateIsInvalid() {
        when(ioReader.read()).thenReturn("invalidDate");

        assertThatThrownBy(() -> dateReader.read())
                .isInstanceOf(InvalidDateException.class);
    }

    @Test
    public void throwInvalidDateExceptionWhenHasInvalidDate() {
        when(ioReader.read()).thenReturn("02Jul2018(Mon),invalidDate");

        assertThatThrownBy(() -> dateReader.read())
                .isInstanceOf(InvalidDateException.class);
    }
}