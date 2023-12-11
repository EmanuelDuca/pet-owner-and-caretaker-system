using System.Security.Claims;
using Domain.DTOs;
using Domain.Models;
using Domain.Models.Enums;
using HttpClients.ClientInterfaces;
using Microsoft.AspNetCore.Components;
using Microsoft.AspNetCore.Components.Authorization;

namespace BlazorWASM.Pages;

public class ManageServices
{
    public Task<AuthenticationState> AuthState { get; set; } = null!;

    private string message = "Loading...";
    private List<Service>? services;
    public string? username;
    public string Email;
    public IAnnouncementService AnnouncementService { get; set; }
    public NavigationManager navMgr { get; set; }


    protected override async Task OnInitializedAsync()
    {
        AuthenticationState authState = await AuthState;
        username = authState.User.Claims.First(claim => claim.Type.Equals(ClaimTypes.Name)).Value;
        Email = authState.User.Claims.FirstOrDefault(c => c.Type.Equals("Email"))!.Value;
        try
        {
            services = (await AnnouncementService.GetServicesAsync(
                new SearchServicesDto()
                {
                    petOwnerEmail = Email,
                    status = null,
                    caretakerEmail = null
                })
                ).ToList();
        }
        catch (Exception e)
        {
            message = "You don't have services.";
        }
    // services = GenerateDummyData();
    }

    private async Task ChangeStatus(Service service)
    {
        Console.WriteLine("Button Was pressed for End Service");
        navMgr.NavigateTo($"/Feedback/{service.Id}");
    }

    private List<Service> GenerateDummyData()
    {
        List<Service> demo = new List<Service>();

        PetOwner petOwner = new PetOwner()
        {
            Email = "demoPetOwner@gmail.com",
            Username = "Vasea Demo",
            Password = "1111",
            Type = "PetOwner",
        };

        CareTaker careTaker = new CareTaker
        {
            Email = "demoCareTaker@gmail.com",
            Username = "Vasea Demo",
            Password = "1111",
            Type = "PetOwner"
        };

        Announcement announcement = new Announcement
        {
            CreationDateTime = DateTime.Today,
            StartDate = DateTime.Today,
            EndDate = DateTime.Today,
            Id = 1,
            PetOwner = petOwner,
            PostalCode = "8700",
            Pet = new Pet
            {
                PetOwner = petOwner,
                PetType = PetType.Type.Cat,
                PetName = "Murca",
                IsVaccinated = true,
                Description = "Some description",
                Weight = 5,
            }
        };

        demo.Add(new Service()
        {
            PetOwner = petOwner,
            CareTaker = careTaker,
            Announcement = announcement,
            Status = ServiceEnum.PLANNED,
        });
        return demo;
    }
}