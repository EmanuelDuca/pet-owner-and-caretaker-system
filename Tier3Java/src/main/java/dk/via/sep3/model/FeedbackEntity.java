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

    private double rating;
    private String feedback;


    public FeedbackEntity(ServiceEntity service, double rating, String feedback)
    {
        this.service = service;
        this.rating = rating;
        this.feedback = feedback;
        this.feedbackId = new FeedbackId(service.getId());
    }

    public FeedbackEntity()
    {

    }

    public ServiceEntity getService()
    {
        return service;
    }

    public double getRating()
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

        public FeedbackId(int serviceId)
        {
            this.serviceId = serviceId;
        }

        public FeedbackId()
        {

        }
    }
}


