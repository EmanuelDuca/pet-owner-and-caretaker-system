package dk.via.sep3.shared;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "announcement")
public class AnnouncementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private PetOwnerEntity petOwner;
    private String description;
    private String startDate;
    private String finishDate;
    @OneToOne
    private PetEntity petEntity;
    private String postalCode;
    private String dateOfCreation;

    public AnnouncementEntity() {
    }

    public AnnouncementEntity(int id, PetOwnerEntity petOwner, String description, String startDate, String finishDate, PetEntity petEntity, String postalCode) {
        this.id = id;
        this.petOwner = petOwner;
        this.description = description;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.petEntity = petEntity;
        this.postalCode = postalCode;
    }

    public AnnouncementEntity(PetOwnerEntity petOwner, String description, String startDate, String finishDate, PetEntity petEntity, String postalCode) {
        this.petOwner = petOwner;
        this.description = description;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.petEntity = petEntity;
        this.postalCode = postalCode;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PetEntity getPet() {
        return petEntity;
    }

    public void setPet(PetEntity petEntity) {
        this.petEntity = petEntity;
    }

    public String getAddress() {
        return postalCode;
    }

    public void setAddress(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public PetEntity getPetEntity() {
        return petEntity;
    }

    public void setPetEntity(PetEntity petEntity) {
        this.petEntity = petEntity;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }


    public PetOwnerEntity getPetOwner() {
        return petOwner;
    }

    public void setPetOwner(PetOwnerEntity petOwner) {
        this.petOwner = petOwner;
    }
}
