package dk.via.sep3.utils;

import com.google.protobuf.Timestamp;

import java.time.*;

public class TimestampConverter
{
    public static Timestamp fromLocalDateTime(LocalDateTime localDateTime)
    {
        // Convert LocalDateTime to seconds and nanoseconds
        long seconds = localDateTime.toEpochSecond(ZoneOffset.UTC);
        int nanos = localDateTime.getNano();

        // Create a Timestamp object
        return Timestamp.newBuilder()
                .setSeconds(seconds)
                .setNanos(nanos)
                .build();
    }

    public static LocalDateTime toLocalDateTime(Timestamp timestamp) {
        long seconds = timestamp.getSeconds();
        int nanos = timestamp.getNanos();

        Instant instant = Instant.ofEpochSecond(seconds, nanos);

        return LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
    }

    public static LocalDate toLocalDate(Timestamp timestamp) {
        Instant instant = Instant.ofEpochSecond(timestamp.getSeconds(), timestamp.getNanos());
        return LocalDateTime.ofInstant(instant, ZoneOffset.UTC).toLocalDate();
    }

    public static Timestamp fromLocalDate(LocalDate localDate) {
        LocalDateTime localDateTime = localDate.atStartOfDay().atZone(ZoneOffset.UTC).toLocalDateTime();
        Instant instant = localDateTime.toInstant(ZoneOffset.UTC);
        return Timestamp.newBuilder()
                .setSeconds(instant.getEpochSecond())
                .setNanos(instant.getNano())
                .build();
    }
}