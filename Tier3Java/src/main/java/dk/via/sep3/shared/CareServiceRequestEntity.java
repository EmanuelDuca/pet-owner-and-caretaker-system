package dk.via.sep3.shared;

import javax.persistence.*;
import java.io.Serializable;

@Entity
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

    private ServiceRequestStatus status;

    public CareServiceRequestEntity(int id, UserEntity initiator, UserEntity recipient, AnnouncementEntity announcement)
    {
        this.id = id;
        this.initiator = initiator;
        this.recipient = recipient;
        this.announcement = announcement;
    }

    public CareServiceRequestEntity(UserEntity initiator, UserEntity recipient, AnnouncementEntity announcement)
    {
        this.initiator = initiator;
        this.recipient = recipient;
        this.announcement = announcement;
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

    @Embeddable public static class CareServiceRequestId implements Serializable
    {
        private String initiator, recipient;
        private int announcement;

        public CareServiceRequestId(String initiator, String recipient, int announcement)
        {
            this.initiator = initiator;
            this.recipient = recipient;
            this.announcement = announcement;
        }

        public CareServiceRequestId()
        {

        }
    }
}
