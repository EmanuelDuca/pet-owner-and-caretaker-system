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
    private String dietDescription = "";
    @ManyToOne
    private PetOwnerEntity petOwner;


    public PetEntity() {
    }

    public PetEntity(String petName, String petType) {
        this.petName = petName;
        this.petType = petType;
    }

    public PetEntity(int id, String petName, String petType, int weight, boolean isVaccinated, String dietDescription, PetOwnerEntity petOwner) {
        this.id = id;
        this.petName = petName;
        this.petType = petType;
        this.weight = weight;
        this.isVaccinated = isVaccinated;
        this.dietDescription = dietDescription;
        this.petOwner = petOwner;
    }

    public PetEntity( String petName, String petType, int weight, boolean isVaccinated, String dietDescription, PetOwnerEntity petOwner) {
        this.petName = petName;
        this.petType = petType;
        this.weight = weight;
        this.isVaccinated = isVaccinated;
        this.dietDescription = dietDescription;
        this.petOwner = petOwner;
    }

    public PetEntity(String petName, String petType, int weight, boolean isVaccinated, String dietDescription) {
        this.id = id;
        this.petName = petName;
        this.petType = petType;
        this.weight = weight;
        this.isVaccinated = isVaccinated;
        this.dietDescription = dietDescription;
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

    public String getDietDescription() {
        return dietDescription;
    }

    public void setDietDescription(String dietDescription) {
        this.dietDescription = dietDescription;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PetOwnerEntity getPetOwner() {
        return petOwner;
    }

    public void setPetOwner(PetOwnerEntity petOwner) {
        this.petOwner = petOwner;
    }
}
