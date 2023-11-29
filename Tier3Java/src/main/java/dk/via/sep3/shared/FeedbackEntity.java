package dk.via.sep3.shared;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
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
    @MapsId("caretakerEmail")
    private CareTakerEntity caretaker;

    private short rating;
    private String feedback;


    public FeedbackEntity(PetServiceEntity service, CareTakerEntity caretaker)
    {
        this.service = service;
        this.caretaker = caretaker;
    }

    public FeedbackEntity()
    {

    }


    public PetServiceEntity getService()
    {
        return service;
    }

    public CareTakerEntity getCaretaker()
    {
        return caretaker;
    }

    @Embeddable
    public static class FeedbackId implements Serializable
    {
        private int serviceId;
        private String caretakerEmail;
    }
}


