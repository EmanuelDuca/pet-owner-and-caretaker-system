namespace Domain.Models;

public class Feedback
{
    public int ServiceId { get; set; }
    public double Rating { get; set; }
    public string FeedbackText { get; set; }
}