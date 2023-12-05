namespace Domain.Models;

public class Feedback
{
    public int serviceId { get; set; }
    public string caretakerEmail { get; set; }
    public double rating { get; set; }
    public string feedback { get; set; }
}