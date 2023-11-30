package dk.via.sep3.shared;

import origin.protobuf.ServiceProto;
import origin.protobuf.ServiceStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "care_service")
public class PetServiceEntity
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

    public PetServiceEntity(int id, UserEntity careTaker, UserEntity petOwner, AnnouncementEntity announcement, ServiceStatus status)
    {
        this.id = id;
        this.careTaker = careTaker;
        this.petOwner = petOwner;
        this.announcement = announcement;
        this.status = status;
    }

    public PetServiceEntity(UserEntity careTaker, UserEntity petOwner, AnnouncementEntity announcement)
    {
        this.id = id;
        this.careTaker = careTaker;
        this.petOwner = petOwner;
        this.announcement = announcement;
        this.status=ServiceStatus.PLANNED;
    }

    public PetServiceEntity()
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
