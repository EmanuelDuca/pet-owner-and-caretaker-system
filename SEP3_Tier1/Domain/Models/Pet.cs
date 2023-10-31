namespace Domain.Models;

public class Pet
{
    public int Id { get; set; }
    public string PetName { get; init; }
    public string PetType { get; init; }
    public int Weight { get; init; }
    public bool IsVaccinated { get; init; }
    public string Description { get; init; }
}