using Google.Protobuf.WellKnownTypes;

namespace GrpcClient.Utils;

public class TimestampConverter
{
    public static DateTime ToDateTime(Timestamp timestamp)
    {
        return new DateTime(timestamp.Nanos / 100, DateTimeKind.Utc);
    }

    public static Timestamp FromDateTime(DateTime dateTime)
    {
        DateTime df = new DateTime(dateTime.Ticks, DateTimeKind.Utc);
        return Timestamp.FromDateTime(df);
    }
}