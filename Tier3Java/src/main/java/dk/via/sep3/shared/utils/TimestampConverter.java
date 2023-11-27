package dk.via.sep3.shared.utils;

import com.google.protobuf.Timestamp;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

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
        // Get seconds and nanoseconds from the Timestamp object
        long seconds = timestamp.getSeconds();
        int nanos = timestamp.getNanos();

        // Create an Instant using seconds and nanoseconds
        Instant instant = Instant.ofEpochSecond(seconds, nanos);

        // Convert Instant to LocalDateTime in UTC
        return LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
    }
}