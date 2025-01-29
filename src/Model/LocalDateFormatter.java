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
        if(date == null) {
            return "";
        }else{
            return date.format(formatter);
        }
    }

    public static LocalDate stringToDate(String date) throws DateTimeParseException {
        if (date.equals("")) {
            return null;
        }else{
            return LocalDate.parse(date, formatter);
        }
    }
}
