package dk.via.sep3.shared;

import origin.protobuf.ServiceProto;
import origin.protobuf.ServiceStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "care_service")
public class PetServiceEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private CareTakerEntity careTaker;
    @OneToOne
    private PetOwnerEntity petOwner;
    @OneToOne
    private AnnouncementEntity announcement;

    private ServiceStatus status;

    public PetServiceEntity(int id, CareTakerEntity careTaker, PetOwnerEntity petOwner, AnnouncementEntity announcement, ServiceStatus status)
    {
        this.id = id;
        this.careTaker = careTaker;
        this.petOwner = petOwner;
        this.announcement = announcement;
        this.status = status;
    }

    public PetServiceEntity(CareTakerEntity careTaker, PetOwnerEntity petOwner, AnnouncementEntity announcement)
    {
        this.id = id;
        this.careTaker = careTaker;
        this.petOwner = petOwner;
        this.announcement = announcement;
        this.status=ServiceStatus.PLANNED;
    }

    public PetServiceEntity()
    {

    }

    public CareTakerEntity getCareTaker()
    {
        return careTaker;
    }

    public PetOwnerEntity getPetOwner()
    {
        return petOwner;
    }

    public LocalDateTime getStartDate()
    {
        return announcement.getStartDate();
    }

    public LocalDateTime getFinishDate()
    {
        return announcement.getFinishDate();
    }

    public AnnouncementEntity getAnnouncement()
    {
        return announcement;
    }

    public ServiceStatus getStatus()
    {
        return status;
    }

    public PetServiceEntity setStatus(ServiceStatus status)
    {
        this.status = status;
        return this;
    }

    public int getId()
    {
        return id;
    }
}
