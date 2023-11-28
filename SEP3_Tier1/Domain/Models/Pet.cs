namespace Domain.Models;

public class Pet
{
    public int Id { get; set; }
    public string PetName { get; set; }
    public PetType.Type PetType { get; set; }
    public int Weight { get; set; }
    public bool IsVaccinated { get; set; }
    public string Description { get; set; }
    public PetOwner? PetOwner { get; set; }
}