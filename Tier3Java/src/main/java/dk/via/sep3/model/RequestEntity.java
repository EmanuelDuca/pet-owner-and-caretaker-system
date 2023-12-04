package dk.via.sep3.model;
import origin.protobuf.ServiceRequestProto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "care_service_request")
public class RequestEntity
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

    private ServiceRequestProto.Status status;

    private LocalDateTime dateTime;

    public RequestEntity(int id, UserEntity initiator, UserEntity recipient, AnnouncementEntity announcement)
    {
        this.id = id;
        this.initiator = initiator;
        this.recipient = recipient;
        this.announcement = announcement;
        this.dateTime = LocalDateTime.now();
        this.status = ServiceRequestProto.Status.SENT;
    }

    public RequestEntity(UserEntity initiator, UserEntity recipient, AnnouncementEntity announcement)
    {
        this.initiator = initiator;
        this.recipient = recipient;
        this.announcement = announcement;
        this.dateTime = LocalDateTime.now();
        this.status = ServiceRequestProto.Status.SENT;
    }

    public RequestEntity()
    {

    }

    public RequestEntity setStatus(ServiceRequestProto.Status status)
    {
        this.status = status;
        return this;
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
