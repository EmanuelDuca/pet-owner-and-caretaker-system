using Microsoft.AspNetCore.Components;
using Microsoft.AspNetCore.Components.Authorization;
using Microsoft.AspNetCore.SignalR.Client;

namespace BlazorWASM.Pages;

public class Notification
{
    private int notificationNumber = 0;
    private HubConnection? hubConnection;
    public Task<AuthenticationState> AuthState { get; set; } = null!;
    public Action UpdateInvoke { get; set; }
    
    protected override async Task OnInitializedAsync()
    {
        
    }

    private async Task Update()
    {
        Console.WriteLine("Uraaa");
        AuthenticationState authState = await AuthState;
        if (authState.User.Identity != null)
        {
            // hubConnection = new HubConnectionBuilder()
            // .WithUrl("https://localhost:7230/offers", 
            //         o =>
            //             o.AccessTokenProvider = async () => await Task.FromResult<string?>(await authService.GetJWT()))
            //     .Build();
            //
            // hubConnection.On<int>("Receive", (numOfMessages) =>
            // {
            //     notificationNumber = numOfMessages;
            //     InvokeAsync(StateHasChanged);
            // });
            //
            // await hubConnection.StartAsync();
        }
    }
    
    private async Task InvokeMethod()
    {
        UpdateInvoke.Invoke();
        Console.WriteLine("Uraaa2");
    }

}