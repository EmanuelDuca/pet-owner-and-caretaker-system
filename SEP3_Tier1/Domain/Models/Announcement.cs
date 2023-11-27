namespace Domain.Models;

public class Announcement
{
    public int Id { get; set; }
    public PetOwner PetOwner { get; set; }
    public DateTime StartDate { get; set; }
    public DateTime EndDate { get; set; }
    public string PostalCode { get; set; }
    public string ServiceDescription { get; set; }
    public DateTime CreationDateTime { get; set; }
    public Pet Pet { get; set; }
}