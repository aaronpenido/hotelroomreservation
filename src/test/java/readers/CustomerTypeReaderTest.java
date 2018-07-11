package readers;

import enums.CustomerType;
import exceptions.InvalidCustomerTypeException;
import models.io.IOReader;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerTypeReaderTest {

    private CustomerTypeReader customerTypeReader;

    @Mock
    private IOReader ioReader;

    @Before
    public void setUp() {
        customerTypeReader = new CommandLineCustomerTypeReader(ioReader);
    }

    @Test
    public void readRegularCustomer() {
        when(ioReader.read()).thenReturn("Regular");

        CustomerType customerType = customerTypeReader.read();

        assertThat(customerType).isEqualTo(CustomerType.REGULAR);
    }

    @Test
    public void readRewardsCustomerType() {
        when(ioReader.read()).thenReturn("Rewards");

        CustomerType customerType = customerTypeReader.read();

        assertThat(customerType).isEqualTo(CustomerType.REWARDS);
    }

    @Test
    public void throwExceptionWhenCustomerTypeIsNull() {
        when(ioReader.read()).thenReturn(null);

        assertThatThrownBy(() -> customerTypeReader.read())
                .isInstanceOf(InvalidCustomerTypeException.class);
    }

    @Test
    public void throwExceptionWhenCustomerTypeIsEmpty() {
        when(ioReader.read()).thenReturn("");

        assertThatThrownBy(() -> customerTypeReader.read())
                .isInstanceOf(InvalidCustomerTypeException.class);
    }

    @Test
    public void throwExceptionWhenCustomerTypeIsDifferentFromRewardsOrRegular() {
        when(ioReader.read()).thenReturn("Invalid");

        assertThatThrownBy(() -> customerTypeReader.read())
                .isInstanceOf(InvalidCustomerTypeException.class);
    }
}