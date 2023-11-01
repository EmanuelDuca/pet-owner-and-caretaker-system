package origin.shared;

public class PetEntity {
    private String petName;
    private String petType;
    private int weight;
    private boolean isVaccinated = false;
    private String dietDescription ="";

    public PetEntity(String petName, String petType,int weight, boolean isVaccinated, String dietDescription) {
        this.petName = petName;
        this.petType = petType;
        this.weight = weight;
        this.isVaccinated = isVaccinated;
        this.dietDescription = dietDescription;
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
}
