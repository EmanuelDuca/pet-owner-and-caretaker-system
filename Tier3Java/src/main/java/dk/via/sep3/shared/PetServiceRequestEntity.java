package dk.via.sep3.shared;

import origin.protobuf.ServiceRequest;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "care_service_request")
public class PetServiceRequestEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private UserEntity initiator;
    @OneToOne
    private UserEntity recipient;
    @OneToOne
    private AnnouncementEntity announcement;

    private ServiceRequest.Status status;

    private LocalDateTime dateTime;

    public PetServiceRequestEntity(int id, UserEntity initiator, UserEntity recipient, AnnouncementEntity announcement)
    {
        this.id = id;
        this.initiator = initiator;
        this.recipient = recipient;
        this.announcement = announcement;
        this.dateTime = LocalDateTime.now();
        this.status = ServiceRequest.Status.NONE;
    }

    public PetServiceRequestEntity(UserEntity initiator, UserEntity recipient, AnnouncementEntity announcement)
    {
        this.initiator = initiator;
        this.recipient = recipient;
        this.announcement = announcement;
        this.dateTime = LocalDateTime.now();
        this.status = ServiceRequest.Status.NONE;
    }

    public PetServiceRequestEntity()
    {

    }

    public int getId()
    {
        return id;
    }

    public AnnouncementEntity getAnnouncement()
    {
        return announcement;
    }

    public UserEntity getInitiator()
    {
        return initiator;
    }

    public UserEntity getRecipient()
    {
        return recipient;
    }
}
