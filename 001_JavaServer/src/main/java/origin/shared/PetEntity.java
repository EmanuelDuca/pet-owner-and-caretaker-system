package origin.shared;

import java.io.Serializable;

public class PetEntity implements Serializable
{
    private String petName;
    private String petType;
    private int weight;
    private String description ="";

    public PetEntity(String petName, String petType,int weight, String description) {
        this.petName = petName;
        this.petType = petType;
        this.weight = weight;
        this.description = description;
    }

    public PetEntity() {
    }

    public PetEntity(String petName, String petType) {
        this.petName = petName;
        this.petType = petType;
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
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PetEntity{" +
                "petName='" + petName + '\'' +
                ", petType='" + petType + '\'' +
                ", weight=" + weight +
                ", dietDescription='" + description + '\'' +
                '}';
    }
}
