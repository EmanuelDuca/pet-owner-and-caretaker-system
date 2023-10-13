namespace Domain.Models;

public class Announcement
{
    public int Id { get; set; }
    public User petOwner { get; init; }
    public DateTime StartDate { get; set; }
    public DateTime EndDate { get; set; }
    public string? PostalCode { get; set; }
    public string ServiceDescription { get; set; }
}