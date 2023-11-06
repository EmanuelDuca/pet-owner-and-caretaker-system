package origin.shared;

import java.io.Serializable;

public class TimeIntervalEntity implements Serializable
{
    private final String startDate;
    private final String endDate;

    public TimeIntervalEntity(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return "TimeIntervalEntity{" +
                "startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
