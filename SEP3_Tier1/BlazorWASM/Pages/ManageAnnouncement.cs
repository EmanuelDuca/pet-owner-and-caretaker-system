using System.Security.Claims;
using Blazored.LocalStorage;
using BlazorWASM.Pages.Components;
using Domain.DTOs;
using Domain.Models;
using HttpClients.ClientInterfaces;
using Microsoft.AspNetCore.Components.Authorization;
using Radzen;

namespace BlazorWASM.Pages;

public class ManageAnnouncement
{
    public ILocalStorageService localStorageService { get; set; }
    public IAnnouncementService announcementService { get; set; }
    public Task<AuthenticationState> AuthState { get; set; } = null!;
    
    public int Id { get; set; }
    private Announcement? announcement;
    private PetDropDown PetList;
    private string ValidatorStyles = "position: relative; width: 20%; margin-left: auto; display: block;";
    private bool isNewPet;
    private IEnumerable<Claim>? userClaims;
    private string backgroundImageUrl;
    
    CreatePetDto createPetDto;
    
    
    
    protected override async Task OnInitializedAsync()
    {
        AuthenticationState authState = await AuthState;
        backgroundImageUrl = await localStorageService.GetItemAsStringAsync("backgroundImage");
        ClaimsPrincipal user = authState.User;
        userClaims = user.Claims;
        string userEmail = user.Claims.FirstOrDefault(c => c.Type.Equals("Email"))!.Value;
        
        try
        {
            announcement = await announcementService.GetByIdAsync(Id);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
        }
        
        
    }
    
    private async Task UpdateAnnouncement()
    {
        try
        {
            UpdateAnnouncementDto dto = new UpdateAnnouncementDto(Id);
            dto.Pet = new Pet();
            
            dto = FetchDataFromAnnouncementComponent(dto, announcement);
            
            await announcementService.UpdateAsync(dto);

            NotificationService.Notify(new NotificationMessage()
            {
                Severity = NotificationSeverity.Success,
                Duration = 6000,
                Detail = "Announcement is created"
            });
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            NotificationService.Notify(new NotificationMessage()
            {
                Severity = NotificationSeverity.Error,
                Duration = 6000,
                Detail = e.Message
            });
            
        }
    }

    private UpdateAnnouncementDto FetchDataFromAnnouncementComponent(UpdateAnnouncementDto dto, Announcement announce)
    {
        dto.StartDate = announce.StartDate;
        dto.EndDate = announce.EndDate;
        dto.PostalCode = announce.PostalCode;
        dto.ServiceDescription = announce.ServiceDescription;
        
        //Update Pet
        dto.Pet.PetType = announcement.Pet.PetType;
        dto.Pet.PetName = announcement.Pet.PetName;
        dto.Pet.Description = announcement.Pet.Description;
        dto.Pet.Weight = announcement.Pet.Weight;
        dto.Pet.IsVaccinated = announcement.Pet.IsVaccinated;
        return dto;
    }
}