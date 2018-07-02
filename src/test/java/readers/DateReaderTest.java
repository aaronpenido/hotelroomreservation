package readers;

import exceptions.InvalidDateException;
import models.io.IOReader;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.Month;

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
    public void readValidDate() throws InvalidDateException {
        String validDate = "02Jul2018(Mon)";
        LocalDate expectedDate = LocalDate.of(2018, Month.JULY, 02);

        when(ioReader.read()).thenReturn(validDate);

        LocalDate date = dateReader.read();

        assertThat(date).isEqualTo(expectedDate);
    }

    @Test
    public void throwInvalidDateExceptionWhenDateIsNull() {
        when(ioReader.read()).thenReturn(null);

        assertThatThrownBy(() -> dateReader.read())
                .isInstanceOf(InvalidDateException.class);
    }

    @Test
    public void throwInvalidDateExceptionWhenDateIsEmpty() {
        when(ioReader.read()).thenReturn("");

        assertThatThrownBy(() -> dateReader.read())
                .isInstanceOf(InvalidDateException.class);
    }

    @Test
    public void throwInvalidDateExceptionWhenDateIsInvalid() {
        when(ioReader.read()).thenReturn("invalidDate");

        assertThatThrownBy(() -> dateReader.read())
                .isInstanceOf(InvalidDateException.class);
    }
}