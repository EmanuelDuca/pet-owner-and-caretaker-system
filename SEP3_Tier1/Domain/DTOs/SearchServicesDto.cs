namespace Domain.DTOs;

public class SearchServicesDto : SearchDto
{
    public string caretakerEmail { get; set; }
    public string petOwnerEmail { get; set; }
    public int status { get; set; }
    
}