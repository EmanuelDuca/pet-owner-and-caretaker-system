using Domain.Models;

namespace Domain.DTOs;

public class AnnouncementCreationDto
{
    public PetOwner petOwner { get; }
    public DateTime StartDate { get; set; }
    public DateTime EndDate { get; set; }
    public string? PostalCode { get; set; }
    public string ServiceDescription { get; set; }

    
    public AnnouncementCreationDto(PetOwner petOwner, DateTime startDate,
        DateTime endDate, string serviceDescription)
    {
        this.petOwner = petOwner;
        StartDate = startDate;
        EndDate = endDate;
        ServiceDescription = serviceDescription;
    }
}