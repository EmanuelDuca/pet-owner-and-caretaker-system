package dk.via.sep3.model;

import origin.protobuf.ServiceStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "care_service")
public class ServiceEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private UserEntity careTaker;
    @OneToOne
    private UserEntity petOwner;
    @OneToOne
    private AnnouncementEntity announcement;

    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "service")
    private FeedbackEntity feedback;

    private ServiceStatus status;

    public ServiceEntity(int id, UserEntity careTaker, UserEntity petOwner, AnnouncementEntity announcement, ServiceStatus status)
    {
        this.id = id;
        this.careTaker = careTaker;
        this.petOwner = petOwner;
        this.announcement = announcement;
        this.status = status;
    }

    public ServiceEntity(UserEntity careTaker, UserEntity petOwner, AnnouncementEntity announcement)
    {
        this.id = id;
        this.careTaker = careTaker;
        this.petOwner = petOwner;
        this.announcement = announcement;
        this.status=ServiceStatus.PLANNED;
    }

    public ServiceEntity()
    {

    }

    public FeedbackEntity getFeedback()
    {
        return feedback;
    }

    public void setFeedback(FeedbackEntity feedback)
    {
        this.feedback = feedback;
    }

    public UserEntity getCareTaker()
    {
        return careTaker;
    }

    public UserEntity getPetOwner()
    {
        return petOwner;
    }

    public LocalDateTime getStartDate()
    {
        return announcement.getStartDate();
    }

    public LocalDateTime getFinishDate()
    {
        return announcement.getFinishDate();
    }

    public AnnouncementEntity getAnnouncement()
    {
        return announcement;
    }

    public ServiceStatus getStatus()
    {
        return status;
    }

    public void setStatus(ServiceStatus status)
    {
        this.status = status;
    }

    public int getId()
    {
        return id;
    }
}
