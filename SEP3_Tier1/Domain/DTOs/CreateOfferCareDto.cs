namespace Domain.DTOs;

public class CreateOfferCareDto
{
    public string InitiatorId { get; set; }
    public string RecipientId { get; set; }
    public int Id { get; set; }
    public int AnnouncementId { get; set; }
    public int RequestEnum { get; set; }
    public DateTime CreationDateTime { get; set; }
}