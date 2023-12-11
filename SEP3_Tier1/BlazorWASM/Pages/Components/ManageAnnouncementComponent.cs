using Domain.Models;

namespace BlazorWASM.Pages.Components;

public class ManageAnnouncementComponent
{
    public Announcement Announcement { get; set; }
    
    public Action OnSubmitAction { get; set; }
    
    public string ActionName { get; set; }
    
    public string ForPage { get; set; }
    
    private string ValidatorStyles = "position: relative; width: 20%; margin-left: auto; display: block;";
    private bool isNewPet;
    private PetDropDown PetList;

    private void SubmitAction()
    {
        OnSubmitAction?.Invoke();
    }
}