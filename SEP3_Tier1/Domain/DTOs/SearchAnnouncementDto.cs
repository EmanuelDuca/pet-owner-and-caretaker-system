
namespace Domain.DTOs;

public class SearchAnnouncementDto: SearchDto
{
    public string? StartTime { get; }
    public string? EndTime { get; }
    public string? Description { get; }
    public string? PostalCode { get; }

    public SearchAnnouncementDto(string? startTime, string? endTime, string? description, string? postalCode)
    {
        StartTime = startTime;
        EndTime = endTime;
        Description = description;
        PostalCode = postalCode;
    }
}