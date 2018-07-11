package readers;

import enums.CustomerType;
import exceptions.DateNotInformedException;
import exceptions.InvalidCustomerTypeException;
import exceptions.ValuesNotInformedException;
import models.Date;
import models.io.IOReader;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputReader {

    private IOReader ioReader;
    private List<Date> dates = new ArrayList<>();
    private CustomerType customerType;

    InputReader(IOReader ioReader) {
        this.ioReader = ioReader;
        setValuesFromInput();
    }

    public List<Date> getDates() {
        return dates;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    private void setValuesFromInput() {
        String inputValues = readFromInput();

        throwValuesNotInformedExceptionIfValuesAreNullOrEmpty(inputValues);

        List<String> values = splitValuesFromInput(inputValues);

        throwDateNotInformedExceptionIfValuesDoesNotContainDates(values);

        setCustomerTypeFromInput(values.get(0));

        setDatesFromInput(values.get(1));
    }

    private String readFromInput() {
        return ioReader.read();
    }

    private List<String> splitValuesFromInput(String inputValues) {
        return Arrays.stream(
                inputValues.split(":"))
                .collect(Collectors.toList());
    }

    private void setCustomerTypeFromInput(String customerType) {
        try {
            this.customerType = CustomerType.valueOf(customerType.toUpperCase());
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new InvalidCustomerTypeException();
        }
    }

    private void setDatesFromInput(String dates) {
        Arrays.stream(dates.split(","))
                .map(this::getDateFromString)
                .forEachOrdered(this.dates::add);
    }

    private Date getDateFromString(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyy(EEE)");
        return new Date(date.trim(), formatter);
    }

    private void throwValuesNotInformedExceptionIfValuesAreNullOrEmpty(String inputValues) {
        if (inputValues == null || inputValues.isEmpty()) {
            throw new ValuesNotInformedException();
        }
    }

    private void throwDateNotInformedExceptionIfValuesDoesNotContainDates(List<String> values) {
        if (values.size() == 1) {
            throw new DateNotInformedException();
        }
    }
}
