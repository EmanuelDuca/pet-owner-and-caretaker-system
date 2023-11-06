package origin.mappers;


import origin.protobuf.TimeIntervalProto;
import origin.shared.TimeIntervalEntity;

public class DateIntervalMapper {
    public static TimeIntervalProto mapToProto(TimeIntervalEntity timeIntervalEntity)
    {
        return TimeIntervalProto.newBuilder()
                .setStartDate(timeIntervalEntity.getStartDate())
                .setFinishDate(timeIntervalEntity.getEndDate())
                .build();
    }

    public static TimeIntervalEntity mapToShared(TimeIntervalProto timeInterval)
    {
        return new TimeIntervalEntity(
                timeInterval.getStartDate(),
                timeInterval.getFinishDate()

        );
    }

}
