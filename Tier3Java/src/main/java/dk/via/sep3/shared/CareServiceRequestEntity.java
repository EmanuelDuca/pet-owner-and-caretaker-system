package dk.via.sep3.shared;

import origin.protobuf.ServiceRequest;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "care_service_request")
public class CareServiceRequestEntity
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

    public CareServiceRequestEntity(int id, UserEntity initiator, UserEntity recipient, AnnouncementEntity announcement)
    {
        this.id = id;
        this.initiator = initiator;
        this.recipient = recipient;
        this.announcement = announcement;
        this.dateTime = LocalDateTime.now();
    }

    public CareServiceRequestEntity(UserEntity initiator, UserEntity recipient, AnnouncementEntity announcement)
    {
        this.initiator = initiator;
        this.recipient = recipient;
        this.announcement = announcement;
        this.status = ServiceRequest.Status.NONE;
    }

    public CareServiceRequestEntity()
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
