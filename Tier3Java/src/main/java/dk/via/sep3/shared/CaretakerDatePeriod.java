package dk.via.sep3.shared;

import com.google.protobuf.Timestamp;
import dk.via.sep3.utils.TimestampConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class CaretakerDatePeriod
{
    @EmbeddedId
    private CaretakerTimePeriodId id;

    @ManyToOne
    @MapsId("caretakerEmail")
    private UserEntity careTaker;

    @Column(name = "start_date", insertable = false, updatable = false)
    private LocalDate startDate;
    private LocalDate endDate;

    public CaretakerDatePeriod(UserEntity careTaker, LocalDate startDate, LocalDate endDate)
    {
        id = new CaretakerTimePeriodId(careTaker.getEmail(), startDate);
        this.careTaker = careTaker;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public CaretakerDatePeriod(UserEntity careTaker, LocalDate startDate)
    {
        id = new CaretakerTimePeriodId(careTaker.getEmail(), startDate);
        this.careTaker = careTaker;
        this.startDate = startDate;
        this.endDate = startDate;
    }


    public CaretakerDatePeriod()
    {

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
