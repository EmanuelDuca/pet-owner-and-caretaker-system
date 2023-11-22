namespace Domain.Models;

public class Pet
{
    public int Id { get; set; }
    public string PetName { get; init; }
    public PetType.Type PetType { get; init; }
    public int Weight { get; init; }
    public bool IsVaccinated { get; init; }
    public string Description { get; init; }
    public PetOwner PetOwner { get; init; }
}