using Domain.Models;
using Domain.Models.Enums;
using HttpClients.ClientInterfaces;
using Microsoft.AspNetCore.Components;

namespace BlazorWASM.Pages.Components;

public class ServiceComponent
{
    public Service Service { get; set; }
    public string ImageSrc { get; set; } = null;
    public IPexelsService ImageService { get; set; }

    
    string value = "Select State";
    IEnumerable<string> companyNames;
    
    [Parameter] public EventCallback OnClickCallback { get; set; }
    
    protected override async Task OnInitializedAsync()
    {
        await base.OnInitializedAsync();
        ImageSrc = await ImageService.SearchPetImage(PetType.NameFromPetType(Service.Announcement.Pet.PetType), 10);
        companyNames = new[] { "Planned", "In Progress", "Done" };

        switch (Service.Status)
        {
            case ServiceEnum.PLANNED:
                value = "Planned";
                break;
            case ServiceEnum.IN_PROGRESS:
                value = "In Progress";
                break;
            case ServiceEnum.DONE:
                value = "Done";
                break;
        }
    }
    
    private async Task OnClick()
    {
        await OnClickCallback.InvokeAsync();
    }
}