
using Domain.Models;

namespace Domain.DTOs;

public class SearchAnnouncementDto : SearchDto
{
    public DateTime? StartTime { get; set; }
    public DateTime? EndTime { get; set; }
    public string? DescriptionContains { get; set; }
    public string? PostalCode { get; set; }
    public string? UserEmail { get; set; }

    public IEnumerable<PetType.Type>? PetTypes { get; set; }
}