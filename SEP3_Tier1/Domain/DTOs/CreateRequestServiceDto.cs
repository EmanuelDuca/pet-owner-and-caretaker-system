namespace Domain.DTOs;

public class CreateRequestServiceDto
{
    public int InitiatorId { get; set; }
    public int RecipientId { get; set; }
    public int Id { get; set; }
    public int AnnouncementId { get; set; }
    public int RequestEnum { get; set; }
    public DateTime CreationDateTime { get; set; }
}