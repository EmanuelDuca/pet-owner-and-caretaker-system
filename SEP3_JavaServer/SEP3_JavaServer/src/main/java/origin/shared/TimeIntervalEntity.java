package origin.shared;

public class TimeIntervalEntity {
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
}
