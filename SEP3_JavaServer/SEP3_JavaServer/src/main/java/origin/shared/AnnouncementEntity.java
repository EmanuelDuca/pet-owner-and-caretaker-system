package origin.shared;


import java.time.LocalDateTime;
import java.util.Date;

public class AnnouncementEntity {
    private final String petOwnerEmail ;
    private String description;
    private TimeIntervalEntity timeIntervalEntity;
    private PetEntity petEntity;
    private String postalCode;
    private final String dateOfCreation;

    public AnnouncementEntity(String petOwnerEmail, String description, TimeIntervalEntity timeIntervalEntity, PetEntity petEntity, String postalCode) {
        this.petOwnerEmail = petOwnerEmail;
        this.description = description;
        this.timeIntervalEntity = timeIntervalEntity;
        this.petEntity = petEntity;
        this.postalCode = postalCode;
        this.dateOfCreation = LocalDateTime.now().toString();
    }

    public String getPetOwnerEmail() {
        return petOwnerEmail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TimeIntervalEntity getTimeInterval() {
        return timeIntervalEntity;
    }

    public void setTimeInterval(TimeIntervalEntity timeIntervalEntity) {
        this.timeIntervalEntity = timeIntervalEntity;
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

}
