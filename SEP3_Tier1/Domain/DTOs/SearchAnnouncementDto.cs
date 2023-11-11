
using Domain.Models;

namespace Domain.DTOs;

public class SearchAnnouncementDto : SearchDto
{
    public string? StartTime { get; set; }
    public string? EndTime { get; set; }
    public string? DescriptionContains { get; set; }
    public string? PostalCode { get; set; }

    public IEnumerable<PetType.Type>? PetTypes { get; set; }
}