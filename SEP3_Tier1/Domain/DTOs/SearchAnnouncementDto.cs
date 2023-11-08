
namespace Domain.DTOs;

public class SearchAnnouncementDto: SearchDto
{
    public string? StartTime { get; } = null;
    public string? EndTime { get; } = null;
    public string? Description { get; } = null;
    public string? PostalCode { get; } = null;

    public SearchAnnouncementDto(string? startTime, string? endTime, string? description, string? postalCode)
    {
        StartTime = startTime;
        EndTime = endTime;
        Description = description;
        PostalCode = postalCode;
    }

    public SearchAnnouncementDto()
    {
        
    }
}