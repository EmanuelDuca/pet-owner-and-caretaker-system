namespace Domain.Models;

public class ServiceRequest
{
    public User Initiator { get; set; }
    public User Recipient { get; set; }
    public int Id { get; set; }
    public Announcement Announcement { get; set; }
    public int status { get; set; }
    public DateTime CreationDateTime { get; set; }
}