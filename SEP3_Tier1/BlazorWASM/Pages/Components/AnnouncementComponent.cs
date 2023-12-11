using Domain.Models;
using Domain.Models.Enums;
using HttpClients.ClientInterfaces;
using Microsoft.AspNetCore.Components;

namespace BlazorWASM.Pages.Components;

public class AnnouncementComponent
{
    public Announcement Announcement { get; set; }

    [Parameter]
    public string ImageSrc { get; set; } = null;
    [Parameter]
    public bool ShowOfferButton { get; set; }

    private IEnumerable<ServiceRequest>? serviceRequests;

    //The Code bellow is used for testing Create service
    [Parameter] public EventCallback OnClickCallback { get; set; }


    protected override async Task OnInitializedAsync()
    {
        ImageSrc = await ImageService.SearchPetImage(PetType.NameFromPetType(Announcement.Pet.PetType), 10);
        try
        {
            serviceRequests = await CareService.GetRequestsAsync(Announcement.Id);
            serviceRequests = serviceRequests.Where(r => r.RequestEnum == RequestEnum.SENT);
        }
        catch (Exception e)
        {
            Console.WriteLine("opfaeriog");
        }
    }

    public IPexelsService ImageService { get; set; }
    public ICareServiceService CareService { get; set; }

    async Task<string> GetAverageRating(string caretakerEmail)
    {
        var feedbacks = await CareService.GetFeedbacks(caretakerEmail);
        return $"{feedbacks.Average(f => f.Rating)}";
    }

    private async Task AcceptRequest(int requestId)
    {
        try
        {
            await CareService.AcceptAsync(requestId);
            foreach (var request in serviceRequests!.Where(r => r.Id != requestId))
            {
                await DenyRequest(request.Id);
            }
            serviceRequests = await CareService.GetRequestsAsync(Announcement.Id);
            serviceRequests = serviceRequests.Where(r => r.RequestEnum == RequestEnum.SENT);
            StateHasChanged();
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            throw;
        }
        
    }
    
    private async Task DenyRequest(int requestId)
    {
        await CareService.DenyAsync(requestId);
        serviceRequests = serviceRequests!.Where(r => r.Id != requestId).AsEnumerable();
        StateHasChanged();
    }
    
    private async Task OnClick()
    {
        await OnClickCallback.InvokeAsync();
    }
}