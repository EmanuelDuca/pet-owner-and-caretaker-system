package origin.shared;


import java.io.Serializable;
import java.time.LocalDateTime;

public class AnnouncementEntity implements Serializable
{
    private final String petOwnerEmail;
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
        this.dateOfCreation= LocalDateTime.now().toString();
    }

    public String getPetOwnerEmail()
    {
        return petOwnerEmail;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public TimeIntervalEntity getTimeIntervalEntity()
    {
        return timeIntervalEntity;
    }

    public void setTimeIntervalEntity(TimeIntervalEntity timeIntervalEntity)
    {
        this.timeIntervalEntity = timeIntervalEntity;
    }

    public PetEntity getPetEntity()
    {
        return petEntity;
    }

    public void setPetEntity(PetEntity petEntity)
    {
        this.petEntity = petEntity;
    }

    public String getPostalCode()
    {
        return postalCode;
    }

    public void setPostalCode(String postalCode)
    {
        this.postalCode = postalCode;
    }

    public String getDateOfCreation()
    {
        return dateOfCreation;
    }

    @Override
    public String toString() {
        return "AnnouncementEntity{" +
                "petOwnerEmail='" + petOwnerEmail + '\'' +
                ", description='" + description + '\'' +
                ", timeIntervalEntity=" + timeIntervalEntity +
                ", petEntity=" + petEntity +
                ", postalCode='" + postalCode + '\'' +
                ", dateOfCreation='" + dateOfCreation + '\'' +
                '}';
    }
}
