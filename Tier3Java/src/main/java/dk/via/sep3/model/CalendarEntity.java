package dk.via.sep3.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "shedules")
public class CalendarEntity
{
    @EmbeddedId
    private CaretakerTimePeriodId id;

    @ManyToOne
    @MapsId("caretakerEmail")
    private UserEntity careTaker;

    @Column(name = "start_date", insertable = false, updatable = false)
    private LocalDate startDate;
    private LocalDate endDate;

    public CalendarEntity(UserEntity careTaker, LocalDate startDate, LocalDate endDate)
    {
        id = new CaretakerTimePeriodId(careTaker.getEmail(), startDate);
        this.careTaker = careTaker;
        this.startDate = startDate;
        this.endDate = endDate;
    }


    public CalendarEntity()
    {

    }

    public void setCareTaker(UserEntity careTaker)
    {
        this.careTaker = careTaker;
    }

    public void setStartDate(LocalDate startDate)
    {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate)
    {
        this.endDate = endDate;
    }

    public UserEntity getCareTaker()
    {
        return careTaker;
    }

    public LocalDate getEndDate()
    {
        return endDate;
    }

    public LocalDate getStartDate()
    {
        return startDate;
    }

    public static boolean isPeriodWithinExisting(CalendarEntity existingPeriod, LocalDate startDate, LocalDate endDate) {
        return (startDate.isAfter(existingPeriod.getStartDate()))
                && (endDate.isBefore(existingPeriod.getEndDate()));
    }

    public static boolean isPeriodCoveringExisting(CalendarEntity existingPeriod, LocalDate startDate, LocalDate endDate) {
        return (startDate.isBefore(existingPeriod.getStartDate()) || startDate.isEqual(existingPeriod.getStartDate()))
                && (endDate.isAfter(existingPeriod.getEndDate()) || endDate.isEqual(existingPeriod.getEndDate()));
    }

    public static boolean isPeriodOverlapping(CalendarEntity existingPeriod, LocalDate startDate, LocalDate endDate) {
        return startDate.isBefore(existingPeriod.getEndDate()) && endDate.isAfter(existingPeriod.getStartDate());
    }

    @Embeddable
    public static class CaretakerTimePeriodId implements Serializable
    {
        @Column(name = "caretaker_email")
        private String caretakerEmail;

        @Column(name = "start_date")
        private LocalDate startDate;

        public CaretakerTimePeriodId(String caretakerEmail, LocalDate startDate) {
            this.caretakerEmail = caretakerEmail;
            this.startDate = startDate;
        }

        public CaretakerTimePeriodId()
        {

        }

        // Getters and Setters for caretakerEmail
        public String getCaretakerEmail() {
            return caretakerEmail;
        }

        public void setCaretakerEmail(String caretakerEmail) {
            this.caretakerEmail = caretakerEmail;
        }

        // Getters and Setters for startDate
        public LocalDate getStartDate() {
            return startDate;
        }

        public void setStartDate(LocalDate startDate) {
            this.startDate = startDate;
        }
    }
}
