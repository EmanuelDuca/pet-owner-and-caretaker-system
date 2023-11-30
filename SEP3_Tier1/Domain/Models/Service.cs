using Domain.Models.Enums;

namespace Domain.Models;

public class Service
{
    public int Id { get; set; }
    public CareTaker CareTaker { get; set; }
    public PetOwner PetOwner { get; set; }
    public Announcement Announcement { get; set; }
    //private FeedbackEntity feedback { get; set; }
    public ServiceEnum Status { get; set; }
}