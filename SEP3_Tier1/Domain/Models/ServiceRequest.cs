using Domain.Models.Enums;

namespace Domain.Models;

public class ServiceRequest
{
    public int Id { get; set; }
    public User Initiator { get; set; }
    public User Recipient { get; set; }
    public Announcement Announcement { get; set; }
    public RequestEnum RequestEnum { get; set; }
}