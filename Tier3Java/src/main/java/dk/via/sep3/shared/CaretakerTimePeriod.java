package dk.via.sep3.shared;

import com.google.protobuf.Timestamp;
import dk.via.sep3.utils.TimestampConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class CaretakerTimePeriod
{
    @EmbeddedId
    private CaretakerTimePeriodId id;

    @ManyToOne
    @MapsId("caretakerEmail")
    private CareTakerEntity careTaker;

    @Column(name = "start_date", insertable = false, updatable = false)
    private LocalDate startDate;
    private LocalDate endDate;

    public CaretakerTimePeriod(LocalDate startDate, LocalDate endDate)
    {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public CaretakerTimePeriod(LocalDate startDate)
    {
        this.startDate = startDate;
        this.endDate = startDate;
    }

    public CaretakerTimePeriod(Timestamp startDate)
    {
        this.startDate = TimestampConverter.toLocalDate(startDate);
        this.endDate = this.startDate;
    }

    public CaretakerTimePeriod(Timestamp startDate, Timestamp endDate)
    {
        this.startDate = TimestampConverter.toLocalDate(startDate);
        this.endDate = TimestampConverter.toLocalDate(endDate);
    }

    public CaretakerTimePeriod()
    {

    }

    public LocalDate getEndDate()
    {
        return endDate;
    }

    public LocalDate getStartDate()
    {
        return startDate;
    }

    @Embeddable
    public static class CaretakerTimePeriodId implements Serializable
    {
        @Column(name = "caretaker_email")

        private String caretakerEmail;
        @Column(name = "start_date")
        private LocalDate startDate;

        public CaretakerTimePeriodId(String caretakerEmail, LocalDate startDate)
        {
            this.caretakerEmail = caretakerEmail;
            this.startDate = startDate;
        }

        public CaretakerTimePeriodId()
        {

        }
    }
}
