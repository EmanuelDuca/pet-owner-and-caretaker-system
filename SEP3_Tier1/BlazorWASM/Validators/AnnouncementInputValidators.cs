using System.ComponentModel.DataAnnotations;
using Domain.Models;

namespace BlazorWASM.Validators;

public class AnnouncementInputValidators
{
    public DateTime StartDate { get; set; }
    public DateTime EndDate { get; set; }
    [Required(ErrorMessage = "Postal code is required")]
    [StringLength(4)]
    public string Postalcode { get; set; }
    [Required(ErrorMessage = "Description of the announcement is required")]
    public string Description { get; set; }
    [Required(ErrorMessage = "Pet name is required")]
    public string PetName { get; set; }
    public PetType.Type PetType { get; set; }
    public string PetDescription { get; set; }
    public int PetWeight { get; set; }
}