package ao.it.chandsoft.vagaemprego.util;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateTimeUtil {

    public static LocalDate getCurrentDate() {
        return LocalDate.now(Clock.systemDefaultZone());
    }

    public static LocalTime getCurrentTime() {
        return LocalTime.now(Clock.systemDefaultZone());
    }

    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now(Clock.systemDefaultZone());
    }

}
