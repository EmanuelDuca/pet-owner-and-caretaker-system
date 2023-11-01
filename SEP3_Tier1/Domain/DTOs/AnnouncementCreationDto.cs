using Domain.Models;

namespace Domain.DTOs;

public class AnnouncementCreationDto
{
    public int Id { get; set; }
    public string OwnerEmail { get; init; }
    public DateTime StartDate { get; init; }
    public DateTime EndDate { get; init; }
    public string PostalCode { get; init; }
    public string ServiceDescription { get; init; }
    public DateTime CreationDateTime { get; init; }
    public Pet Pet { get; init; }
    
    
}