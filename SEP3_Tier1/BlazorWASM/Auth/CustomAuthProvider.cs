using System.Security.Claims;
using HttpClients.ClientInterfaces;
using Microsoft.AspNetCore.Components.Authorization;

namespace BlazorClient.Auth;

public class CustomAuthProvider : AuthenticationStateProvider
{
    private readonly IUserAuthService authService;

    public CustomAuthProvider(IUserAuthService authService)
    {
        this.authService = authService;
        this.authService.OnAuthStateChanged += AuthStateChanged;
    }
    
    public override async Task<AuthenticationState> GetAuthenticationStateAsync()
    {
        return new AuthenticationState(await authService.GetAuthAsync());
    }
    
    private void AuthStateChanged(ClaimsPrincipal principal)
    {
        NotifyAuthenticationStateChanged(
            Task.FromResult(
                new AuthenticationState(principal)
            )
        );
    }
}