using HttpClients.ClientInterfaces;
using Microsoft.AspNetCore.Components;

namespace BlazorWASM.Pages;

public class LoginButtons
{
    public IAuthService authService { get; set; }
    public NavigationManager navMgr { get; set; }

    private void Login()
    {
        navMgr.NavigateTo("/LoginView");
    }

    private async Task Logout()
    {
        await authService.LogoutAsync();
        navMgr.NavigateTo("/");
    }
}