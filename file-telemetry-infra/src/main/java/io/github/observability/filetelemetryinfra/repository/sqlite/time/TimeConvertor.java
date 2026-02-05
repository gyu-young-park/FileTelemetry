package io.github.observability.filetelemetryinfra.repository.sqlite.time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class TimeConvertor {
    public static long localDateTimeToEpoch(LocalDateTime localDateTime, ZoneOffset timeZone) {
        return localDateTime.atZone(timeZone).toInstant().toEpochMilli();
    }

    public static long localDateTimeToEpoch(LocalDateTime localDateTime) {
        return localDateTime.atZone(ZoneOffset.systemDefault()).toInstant().toEpochMilli();
    }

    public static LocalDateTime epochToLocalDateTime(long epoch, ZoneId zoneId) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(epoch), zoneId);
    }

    public static LocalDateTime epochToLocalDateTime(long epoch) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(epoch), ZoneId.systemDefault());
    }
}
