package io.github.observability.filetelemetryapi.data.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeConvertor {
    private final static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String toPatternString(LocalDateTime localDateTime) {
        return localDateTime.format(dateTimeFormatter);
    }
}
