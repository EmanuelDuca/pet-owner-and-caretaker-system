using System.Security.Claims;
using Blazored.LocalStorage;
using BlazorWASM.Pages.Components;
using BlazorWASM.Validators;
using Domain.DTOs;
using HttpClients.ClientInterfaces;
using Microsoft.AspNetCore.Components;
using Microsoft.AspNetCore.Components.Authorization;
using Radzen;

namespace BlazorWASM.Pages;

public class CreateAnnouncement
{
    public Task<AuthenticationState> AuthState { get; set; } = null!;

    private AnnouncementInputValidators announcementInputs;
    private string ownerEmail;

    private PetDropDown PetList;

    private string ValidatorStyles = "position: relative; width: 20%; margin-left: auto; display: block;";

    private bool isNewPet;

    private IEnumerable<Claim>? userClaims;
    private string backgroundImageUrl;
    
    public ILocalStorageService localStorageService { get; set; }
    public IAnnouncementService announcementService { get; set; }


    protected override async Task OnInitializedAsync()
    {
        announcementInputs = new();
        backgroundImageUrl = await localStorageService.GetItemAsStringAsync("backgroundImage");
        AuthenticationState authState = await AuthState;
        ClaimsPrincipal user = authState.User;
        userClaims = user.Claims;
        ownerEmail = user.Claims.FirstOrDefault(c => c.Type.Equals("Email"))!.Value;

        announcementInputs.StartDate = DateTime.Today;
        announcementInputs.EndDate = DateTime.Today.AddDays(3);
    }


    private async Task TryCreateAnnouncement()
    {
        try
        {
            CreatePetDto createPetDto;

            if (isNewPet)
                createPetDto = new CreatePetDto
                {
                    PetName = announcementInputs.PetName,
                    PetType = announcementInputs.PetType,
                    Weight = announcementInputs.PetWeight,
                    Description = announcementInputs.PetDescription
                };
            else
            {
                createPetDto = new CreatePetDto(PetList.Value);
            }

            CreateAnnouncementDto dto = new CreateAnnouncementDto
            {
                OwnerEmail = ownerEmail,
                StartDate = announcementInputs.StartDate,
                EndDate = announcementInputs.EndDate,
                ServiceDescription = announcementInputs.Description,
                PostalCode = announcementInputs.Postalcode,
                PetDto = createPetDto
            };
            await announcementService.CreateAsync(dto);

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
}