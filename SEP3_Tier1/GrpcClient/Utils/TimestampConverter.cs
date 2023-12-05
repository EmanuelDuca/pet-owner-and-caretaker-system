using Google.Protobuf.WellKnownTypes;

namespace GrpcClient.Utils;

public static class TimestampConverter
{
    public static DateTime ToDateTime(Timestamp timestamp)
    {
        return timestamp.ToDateTime();
    }

    public static Timestamp FromDateTime(DateTime dateTime)
    {
        DateTime df = new DateTime(dateTime.Ticks, DateTimeKind.Utc);
        return Timestamp.FromDateTime(df);
    }
}