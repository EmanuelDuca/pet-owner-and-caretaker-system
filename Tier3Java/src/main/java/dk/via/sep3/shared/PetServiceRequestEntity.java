package dk.via.sep3.shared;
import origin.protobuf.ServiceRequestProto;

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

    private ServiceRequestProto.Status status;

    private LocalDateTime dateTime;

    public PetServiceRequestEntity(int id, UserEntity initiator, UserEntity recipient, AnnouncementEntity announcement)
    {
        this.id = id;
        this.initiator = initiator;
        this.recipient = recipient;
        this.announcement = announcement;
        this.dateTime = LocalDateTime.now();
        this.status = ServiceRequestProto.Status.SENT;
    }

    public PetServiceRequestEntity(UserEntity initiator, UserEntity recipient, AnnouncementEntity announcement)
    {
        this.initiator = initiator;
        this.recipient = recipient;
        this.announcement = announcement;
        this.dateTime = LocalDateTime.now();
        this.status = ServiceRequestProto.Status.SENT;
    }

    public PetServiceRequestEntity()
    {

    }

    public PetServiceRequestEntity setStatus(ServiceRequestProto.Status status)
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
