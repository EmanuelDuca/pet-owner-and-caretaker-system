package dk.via.sep3.shared;

import javax.persistence.*;

@Entity
@Table(name="pet")
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String petName;
    private String petType;
    private int weight;
    private boolean isVaccinated;
    private String description = "";
    @ManyToOne
    private UserEntity petOwner;


    public UserEntity getPetOwner() {
        return petOwner;
    }

    public void setPetOwner(UserEntity petOwner) {
        this.petOwner = petOwner;
    }

    public PetEntity() {
    }

    public PetEntity(String petName, String petType) {
        this.petName = petName;
        this.petType = petType;
    }

    public PetEntity(int id, String petName, String petType, int weight, boolean isVaccinated, String description, UserEntity petOwner) {
        this.id = id;
        this.petName = petName;
        this.petType = petType;
        this.weight = weight;
        this.isVaccinated = isVaccinated;
        this.description = description;
        this.petOwner = petOwner;
    }

    public PetEntity(String petName, String petType, int weight, boolean isVaccinated, String description, UserEntity petOwner) {
        this.petName = petName;
        this.petType = petType;
        this.weight = weight;
        this.isVaccinated = isVaccinated;
        this.description = description;
        this.petOwner = petOwner;
    }

    public PetEntity(String petName, String petType, int weight, boolean isVaccinated, String description) {
        this.id = id;
        this.petName = petName;
        this.petType = petType;
        this.weight = weight;
        this.isVaccinated = isVaccinated;
        this.description = description;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String dietDescription) {
        this.description = dietDescription;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
