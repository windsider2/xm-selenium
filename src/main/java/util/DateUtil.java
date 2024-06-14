package util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class DateUtil {
    public static String getNextWeekDate() {
        return LocalDate.now().plusWeeks(1)
                .with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))
                .format(getFormatter());
    }

    public static String getTomorrowDate() {
        return LocalDate.now().plusDays(1).format(getFormatter());
    }

    public static String getCurrentDate() {
        return LocalDate.now().format(getFormatter());
    }

    private static DateTimeFormatter getFormatter() {
        return DateTimeFormatter.ofPattern("yyyy MMM dd");
    }
}
