using HttpClients.ClientInterfaces;
using Microsoft.AspNetCore.SignalR.Client;

namespace BlazorWASM.Pages;

public class RemoteTest
{
    private HubConnection? hubConnection;
    public IAuthService authService { get; set; }

    private List<string> messages = new List<string>();
    private string? userInput;
    private string? messageInput;

    protected override async Task OnInitializedAsync()
    {
        Console.WriteLine(await authService.GetJWT());
        hubConnection = new HubConnectionBuilder()
            .WithUrl("https://localhost:7230/offers", 
                o =>
                    o.AccessTokenProvider = async () => await Task.FromResult<string?>(await authService.GetJWT()))
            .Build();
        
        hubConnection.On<string, string>("Receive", (user, message) =>
        {
            var encodedMsg = $"{user}:{message}";
            messages.Add(encodedMsg);
            InvokeAsync(StateHasChanged);
        });
        
        await hubConnection.StartAsync();
    }
    
    private async Task Send()
    {
        if (hubConnection is not null)
        {
            await hubConnection.SendAsync("SendMessage", userInput, messageInput);
        }
        else
        {
            messages.Add("error");
        }
    }
    //
    // public bool IsConnected =>
    //     hubConnection?.State == HubConnectionState.Connected;
    //
    public async ValueTask DisposeAsync()
    {
        if (hubConnection is not null)
        {
            await hubConnection.DisposeAsync();
        }
    }
}