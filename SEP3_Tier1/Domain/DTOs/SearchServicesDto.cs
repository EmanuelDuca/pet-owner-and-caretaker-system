using Domain.Models.Enums;

namespace Domain.DTOs;

public class SearchServicesDto : SearchDto
{
    public string? caretakerEmail { get; set; }
    public string petOwnerEmail { get; set; }
    public ServiceEnum? status { get; set; }
    
}