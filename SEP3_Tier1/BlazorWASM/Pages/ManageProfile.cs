using System.Security.Claims;
using Domain.DTOs;
using HttpClients.ClientInterfaces;
using Microsoft.AspNetCore.Components.Authorization;
using Newtonsoft.Json;
using Radzen;

namespace BlazorWASM.Pages;

public class ManageProfile
{
    public Task<AuthenticationState> AuthState { get; set; } = null!;
  
    private string Email;
    private string Username;
    private string Name;
    private string? PhoneNumber;
    private int? Age;
    private string Password;
    public IUserService userService { get; set; }

    
    protected override async Task OnInitializedAsync()
    {
      AuthenticationState authState = await AuthState;
      ClaimsPrincipal user = authState.User;
      FetchDataFromClaims(user);
    }


    private async Task EditProfile()
    {
      try
      {
        UserEditDto dto = new UserEditDto(Email);
        AddInfoInDtoOObject(dto);
        
        //For Debugging
        Console.WriteLine(JsonConvert.SerializeObject(dto));
        await userService.EditProfile(dto);
        SuccessMessage("Profile was updated");
      }
      catch (Exception e)
      {
        Console.WriteLine(e);
        ErrorMessage(e);
      }
    }
  
    private async Task DeleteProfile()
    {
      try
      {
        await userService.DeleteProfile(Email);
        SuccessMessage("Profile was deleted");
      }
      catch (Exception e)
      {
        Console.WriteLine(e);
        ErrorMessage(e);
      }
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

    private void FetchDataFromClaims(ClaimsPrincipal user)
    {
      Username = user.Claims.First(claim => claim.Type.Equals(ClaimTypes.NameIdentifier)).Value;
      Email = user.Claims.FirstOrDefault(c => c.Type.Equals("Email"))!.Value;
      Password = user.Claims.FirstOrDefault(c => c.Type.Equals("Password"))!.Value;
      PhoneNumber = user.Claims.FirstOrDefault(c => c.Type.Equals("PhoneNumber"))!.Value;
      string? numString = user.Claims.FirstOrDefault(c => c.Type.Equals("Age"))?.Value;
      if (string.IsNullOrEmpty(numString))
      {
        Age = null;
      }
      else
      {
        Age = int.Parse(numString);
      }
    }

    private void AddInfoInDtoOObject(UserEditDto dto)
    {
      dto.UserName = Username;
      dto.Password = Password;
      dto.Age = Age;
      dto.PhoneNumber = PhoneNumber;
    }
}