using Domain.Models;

namespace Domain.DTOs;

public class UpdateAnnouncementDto
{
    public int Id { get; }
    public DateTime? StartDate { get; set; }
    public DateTime? EndDate { get; set; }
    public string? PostalCode { get; set; }
    public string? ServiceDescription { get; set; }
    public Pet? Pet { get; set; }
    

    public UpdateAnnouncementDto(int id)
    {
        Id = id;
    }
}