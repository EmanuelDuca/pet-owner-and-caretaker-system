package origin.mappers;


import origin.protobufClasses.TimeInterval;
import origin.shared.TimeIntervalEntity;

public class DateIntervalMapper {
    public static TimeInterval mapToProto(TimeIntervalEntity timeIntervalEntity)
    {
        return TimeInterval.newBuilder()
                .setStartDate(timeIntervalEntity.getStartDate())
                .setFinishDate(timeIntervalEntity.getEndDate())
                .build();
    }

    public static TimeIntervalEntity mapToShared(TimeInterval timeInterval)
    {
        return new TimeIntervalEntity(
                timeInterval.getStartDate(),
                timeInterval.getFinishDate()

        );
    }

}
