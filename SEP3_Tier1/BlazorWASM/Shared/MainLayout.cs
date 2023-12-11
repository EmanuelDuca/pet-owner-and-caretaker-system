using System.Security.Claims;
using Microsoft.AspNetCore.Components;
using Microsoft.AspNetCore.Components.Authorization;

namespace BlazorWASM.Shared;

public class MainLayout
{
    [CascadingParameter]
    public Task<AuthenticationState> AuthState { get; set; } = null!;
    
    protected override async Task OnInitializedAsync()
    {
        AuthenticationState authState = await AuthState;
        ClaimsPrincipal user = authState.User;
    }
}