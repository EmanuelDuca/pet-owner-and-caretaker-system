using System.Security.Claims;
using Domain.DTOs;
using Domain.Models;
using Domain.Models.Enums;
using HttpClients.ClientInterfaces;
using Microsoft.AspNetCore.Components;
using Microsoft.AspNetCore.Components.Authorization;
using Newtonsoft.Json;
using Radzen;

namespace BlazorWASM.Pages;

public class ViewAnnouncements
{
    [CascadingParameter]
    public Task<AuthenticationState> AuthState { get; set; } = null!;
    private string OwnerEmail;
    private string message = "Loading...";
    private string Actor;
    
    private List<Announcement>? announcements;
    private List<PetType.Type> filteredPetTypes = new();
    private string classDropDown = "dropdown-content";
    private bool isVaccinatedFilter;
    private bool isFilterShown;
    
    private DateTime? startDate;
    private DateTime? endDate;
    private string postalCode;
    private string userName;
    
    public IAnnouncementService AnnouncementService { get; set; }


    private bool IsFilterShown
    {
        get => isFilterShown;
        set
        {
            isFilterShown = value;
            classDropDown = "dropdown-content";
            if (isFilterShown)
                classDropDown += " show";
            Console.WriteLine(classDropDown);
        }
    }
    
    protected override async Task OnInitializedAsync()
    {
        AuthenticationState authState = await AuthState;
        ClaimsPrincipal user = authState.User;
        OwnerEmail = user.Claims.FirstOrDefault(c => c.Type.Equals("Email"))!.Value;
        Actor = user.Claims.First(claim => claim.Type.Equals(ClaimTypes.Actor)).Value;
        
        SearchAnnouncementDto dto = new SearchAnnouncementDto();

        try
        {
            announcements = (await AnnouncementService.GetAsync(dto)).ToList();
        }
        catch (Exception e)
        {
            message = e.Message;
        }
    }
    
    public void Search()
    {
        Console.WriteLine("pressed");   
        Console.WriteLine(filteredPetTypes.Count);   
    }

    public void ShowDropDownContent()
    {
        IsFilterShown = !IsFilterShown;
    }
    
    public void OnDropDownChange()
    {
        Console.WriteLine(filteredPetTypes);   
        Console.WriteLine("petType");   
    }
    
    private async void FilterAnnouncements()
    {
        
        SearchAnnouncementDto dto = new SearchAnnouncementDto
        {
            PetTypes = filteredPetTypes,
            StartTime = startDate,
            EndTime = endDate,
            PostalCode = postalCode,
        };

        Console.WriteLine($"$Dto object converted to JSON:\n{JsonConvert.SerializeObject(dto)}");
        
        announcements = (await AnnouncementService.GetAsync(dto)).ToList();
        //Console.WriteLine(JsonConvert.SerializeObject(announcements));
    }

    private async Task OfferServiceRequest(Announcement announcement)
    {
        
        CreateOfferCareDto dto = new CreateOfferCareDto
        {
            InitiatorId = OwnerEmail,
            AnnouncementId = announcement.Id,
            RequestEnum = (int)RequestEnum.SENT,
            CreationDateTime = DateTime.Now,
            RecipientId = announcement.PetOwner.Email,
        };
        
        try
        {
            await AnnouncementService.CreateRequestAsync(dto);
            SuccessMessage("Request was saved");
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            ErrorMessage(e);
        }
        
    Console.WriteLine($"Announcement name: {JsonConvert.SerializeObject(announcement)}");
    }
    
    private void SuccessMessage(String message)
    {
        NotificationService.Notify(new NotificationMessage()
        {
            Severity = NotificationSeverity.Success,
            Duration = 6000,
            Detail = message
        });
    }

    private void ErrorMessage(Exception e)
    {
        NotificationService.Notify(new NotificationMessage()
        {
            Severity = NotificationSeverity.Error,
            Duration = 6000,
            Detail = e.Message
        });
    }
}