package dk.via.sep3.model;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "announcement")
public class AnnouncementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private UserEntity petOwner;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime finishDate;
    @OneToOne(cascade = CascadeType.ALL)
    private PetEntity petEntity;
    private String postalCode;
    private LocalDateTime dateOfCreation;

    public AnnouncementEntity() {
    }

    public AnnouncementEntity(int id, UserEntity petOwner, String description, LocalDateTime startDate, LocalDateTime finishDate, PetEntity petEntity, String postalCode) {
        this.id = id;
        this.petOwner = petOwner;
        this.description = description;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.petEntity = petEntity;
        this.postalCode = postalCode;
    }

    public AnnouncementEntity(UserEntity petOwner, String description, LocalDateTime startDate, LocalDateTime finishDate, PetEntity petEntity, String postalCode) {
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

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDateTime finishDate) {
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

    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public UserEntity getPetOwner() {
        return petOwner;
    }

    public void setPetOwner(UserEntity petOwner) {
        this.petOwner = petOwner;
    }
}
