package dk.via.sep3.model;

import javax.persistence.*;

@Entity
@Table(name="preferences")
public class PreferenceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @JoinColumn(name = "pet_owner_email", referencedColumnName = "email")
    private UserEntity careTaker;
    private String petType;
    private Boolean isVaccinated;
    private int zipCode;


    public PreferenceEntity() {

    }

    public PreferenceEntity(UserEntity careTaker, String petType, Boolean isVaccinated, int zipCode) {
        this.careTaker = careTaker;
        this.petType = petType;
        this.isVaccinated = isVaccinated;
        this.zipCode = zipCode;
    }

    public UserEntity getCareTaker() {
        return careTaker;
    }

    public void setCareTaker(UserEntity careTaker) {
        this.careTaker = careTaker;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public Boolean getVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(Boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}
