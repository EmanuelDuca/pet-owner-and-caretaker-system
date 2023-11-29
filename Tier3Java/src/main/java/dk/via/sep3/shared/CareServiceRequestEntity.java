package dk.via.sep3.shared;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
public class CareServiceRequestEntity
{
    @EmbeddedId
    private CareServiceRequestId id;

    @OneToOne
    private UserEntity initiator;
    @OneToOne
    private UserEntity recipient;
    @OneToOne
    private AnnouncementEntity announcement;

    public CareServiceRequestEntity(UserEntity initiator, UserEntity recipient, AnnouncementEntity announcement)
    {
        id = new CareServiceRequestId(initiator.getEmail(), recipient.getEmail(), announcement.getId());
        this.initiator = initiator;
        this.recipient = recipient;
        this.announcement = announcement;
    }

    public CareServiceRequestEntity()
    {

    }

    public CareServiceRequestId getId()
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
