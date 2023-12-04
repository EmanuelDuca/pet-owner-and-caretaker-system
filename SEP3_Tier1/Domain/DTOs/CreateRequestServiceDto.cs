namespace Domain.DTOs;

public class CreateRequestServiceDto
{
    public string InitiatorEmail { get; set; }
    public string RecipientEmail { get; set; }
    public int Id { get; set; }
    public int AnnouncementId { get; set; }
    public int RequestEnum { get; set; }
    public DateTime CreationDateTime { get; set; }
}