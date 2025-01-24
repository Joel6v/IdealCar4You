package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class LocalDateFormatter {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public LocalDateFormatter() {

    }

    public LocalDateFormatter(String format) {
        formatter = DateTimeFormatter.ofPattern(format);
    }

    public static String dateToString(LocalDate date) {
        return date.format(formatter);
    }

    public static LocalDate stringToDate(String date) throws DateTimeParseException {
        return LocalDate.parse(date, formatter);
    }
}
