package dk.via.sep3.model;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "feedback")
public class FeedbackEntity {

    @EmbeddedId
    private FeedbackId feedbackId;

    @OneToOne
    @MapsId("serviceId")
    private ServiceEntity service;

    @OneToOne
    @MapsId("caretakerEmail")
    private UserEntity caretaker;

    private short rating;
    private String feedback;


    public FeedbackEntity(ServiceEntity service, UserEntity caretaker, short rating, String feedback)
    {
        this.service = service;
        this.caretaker = caretaker;
        this.rating = rating;
        this.feedback = feedback;
        this.feedbackId = new FeedbackId(service.getId(), caretaker.getEmail());
    }

    public FeedbackEntity()
    {

    }


    public ServiceEntity getService()
    {
        return service;
    }

    public UserEntity getCaretaker()
    {
        return caretaker;
    }

    public short getRating()
    {
        return rating;
    }

    public String getFeedback()
    {
        return feedback;
    }

    @Embeddable
    public static class FeedbackId implements Serializable
    {
        private int serviceId;
        private String caretakerEmail;

        public FeedbackId(int serviceId, String caretakerEmail)
        {
            this.serviceId = serviceId;
            this.caretakerEmail = caretakerEmail;
        }

        public FeedbackId()
        {

        }
    }
}


