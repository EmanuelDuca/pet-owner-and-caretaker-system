using System.Security.Claims;
using Domain.DTOs;
using Domain.Models;
using HttpClients.ClientInterfaces;
using Microsoft.AspNetCore.Components;
using Microsoft.AspNetCore.Components.Authorization;

namespace BlazorWASM.Pages;

public class MyProfile
{
    private List<Announcement>? announcements;
    
    public Task<AuthenticationState> AuthState { get; set; } = null!;
    
    public IAnnouncementService AnnouncementService { get; set; }
    public ICareServiceService CareService { get; set; }
    public NavigationManager navMgr { get; set; }
    
    
    private string? email;
    private string? username;
    private string? userType;
    private string message = "Loading...";

    private IEnumerable<ServiceRequest>? serviceRequests;

    protected override async Task OnInitializedAsync()
    {
        AuthenticationState authState = await AuthState;
        email = authState.User.Claims.FirstOrDefault(c => c.Type.Equals("Email"))!.Value;
        username = authState.User.Identity!.Name;
        userType = authState.User.Claims.FirstOrDefault(c => c.Type.Equals(ClaimTypes.Actor))!.Value;
        
        try
        {
            if (userType == "PetOwner")
            {
                announcements = (await AnnouncementService.GetAsync(
                    new SearchAnnouncementDto
                    {
                        UserEmail = email
                    })
                    ).ToList();

                await UpdateServiceRequestsByAnnouncement(announcements.FirstOrDefault()!.Id);
            }
        }
        catch (Exception e)
        {
            message = "You don't have announcements.";
        }
        
    }

    private async Task UpdateServiceRequestsByAnnouncement(int announcementId)
    {
        serviceRequests = await CareService.GetRequestsAsync(announcementId);
    }

    private void OpenEditAnnouncement(int announcementId)
    {
        try
        {
            navMgr.NavigateTo($"/ManageAnnouncement/{announcementId}");
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
        }
    }

    private async Task DeleteAnnouncement(int announcementId)
    {
        try
        {
            Console.WriteLine("Deleting announcement...");
            await AnnouncementService.DeleteAsync(announcementId);
            
            Console.WriteLine();

            // Update the local list by removing the deleted announcement
            announcements?.RemoveAll(a => a.Id == announcementId);

            // Trigger a re-render of the component to reflect the updated data
            StateHasChanged();

            Console.WriteLine("Announcement deleted successfully.");
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
        }
    }
}