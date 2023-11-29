package dk.via.sep3.shared;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Id;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "service_feedback")
public class FeedbackEntity {

    @EmbeddedId
    private FeedbackId feedbackId;

    @OneToOne
    @MapsId("serviceId")
    private PetServiceEntity service;

    @OneToOne
    @MapsId("userEmail")
    private UserEntity user; // caretaker

    private short rating;
    private String feedback;


    public FeedbackEntity(PetServiceEntity service, UserEntity user)
    {
        this.service = service;
        this.user = user;
    }

    public FeedbackEntity()
    {

    }


    public PetServiceEntity getService()
    {
        return service;
    }

    public UserEntity getUser()
    {
        return user;
    }

    @Embeddable
    private static class FeedbackId implements Serializable
    {
        private int serviceId;
        private String userEmail;
    }
}


