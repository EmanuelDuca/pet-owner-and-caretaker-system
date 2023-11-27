using Domain.Models;

namespace Domain.DTOs;

public class CreatePetDto
{
    public int Id { get; init; }
    public string PetName { get; init; }
    public PetType.Type PetType { get; init; }
    public int Weight { get; init; }
    public bool IsVaccinated { get; init; }
    public string Description { get; init; }
    
    public CreatePetDto() {}

    public CreatePetDto(Pet pet)
    {
        Id = pet.Id;
        PetName = pet.PetName;
        PetType = pet.PetType;
        Description = pet.Description;
        Weight = pet.Weight;
        IsVaccinated = pet.IsVaccinated;
    }
}