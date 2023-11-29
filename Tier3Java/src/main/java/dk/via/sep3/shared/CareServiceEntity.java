package dk.via.sep3.shared;

import javax.persistence.*;

@Entity
public class CareServiceEntity
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

    private ServiceStatus status;

    public CareServiceEntity(int id, UserEntity initiator, UserEntity recipient, AnnouncementEntity announcement, ServiceStatus status)
    {
        this.id = id;
        this.initiator = initiator;
        this.recipient = recipient;
        this.announcement = announcement;
        this.status = status;
    }

    public CareServiceEntity()
    {

    }

    public UserEntity getInitiator()
    {
        return initiator;
    }

    public UserEntity getRecipient()
    {
        return recipient;
    }

    public AnnouncementEntity getAnnouncement()
    {
        return announcement;
    }

    public ServiceStatus getStatus()
    {
        return status;
    }

    public int getId()
    {
        return id;
    }
}
