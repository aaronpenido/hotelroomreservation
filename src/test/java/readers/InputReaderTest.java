package readers;

import enums.CustomerType;
import exceptions.DateNotInformedException;
import exceptions.InvalidCustomerTypeException;
import exceptions.InvalidDateException;
import exceptions.ValuesNotInformedException;
import models.Date;
import models.io.IOReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class InputReaderTest {

    @Mock
    private IOReader ioReader;

    @Test
    public void getRegularCustomerTypeFromInput() {
        String inputValue = "regular: 11Jul2018(Wed)";

        when(ioReader.read()).thenReturn(inputValue);

        InputReader inputReader = new InputReader(ioReader);

        assertThat(inputReader.getCustomerType()).isEqualTo(CustomerType.REGULAR);
    }

    @Test
    public void getRewardsCustomerTypeFromInput() {
        String inputValue = "rewards: 11Jul2018(Wed)";

        when(ioReader.read()).thenReturn(inputValue);

        InputReader inputReader = new InputReader(ioReader);

        assertThat(inputReader.getCustomerType()).isEqualTo(CustomerType.REWARDS);
    }

    @Test
    public void getDatesFromInput() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyy(EEE)");
        String date1 = "11Jul2018(Wed)";
        String date2 = "12Jul2018(Thu)";
        List<Date> expectedDates = Arrays.asList(
                new Date(date1, formatter),
                new Date(date2, formatter));

        String inputValue = String.format("regular: %s, %s", date1, date2);
        when(ioReader.read()).thenReturn(inputValue);

        InputReader inputReader = new InputReader(ioReader);

        assertThat(inputReader.getDates()).isEqualTo(expectedDates);
    }

    @Test
    public void throwDateNotInformedException() {
        String inputValue = "rewards:";

        when(ioReader.read()).thenReturn(inputValue);

        assertThatThrownBy(() -> new InputReader(ioReader))
                .isInstanceOf(DateNotInformedException.class);
    }

    @Test
    public void throwInvalidDateException() {
        String inputValue = "rewards:invalidDate";

        when(ioReader.read()).thenReturn(inputValue);

        assertThatThrownBy(() -> new InputReader(ioReader))
                .isInstanceOf(InvalidDateException.class);
    }

    @Test
    public void throwInvalidCustomerTypeException() {
        String inputValue = "invalidCustomerType:11Jul2018(Wed)";

        when(ioReader.read()).thenReturn(inputValue);

        assertThatThrownBy(() -> new InputReader(ioReader))
                .isInstanceOf(InvalidCustomerTypeException.class);
    }

    @Test
    public void throwValuesNotInformedExceptionWhenValuesAreNull() {
        assertThatThrownBy(() -> new InputReader(ioReader))
                .isInstanceOf(ValuesNotInformedException.class);
    }

    @Test
    public void throwValuesNotInformedExceptionWhenValuesAreEmpty() {
        String inputValue = "";

        when(ioReader.read()).thenReturn(inputValue);

        assertThatThrownBy(() -> new InputReader(ioReader))
                .isInstanceOf(ValuesNotInformedException.class);
    }
}