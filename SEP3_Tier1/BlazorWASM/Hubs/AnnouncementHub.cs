using Microsoft.AspNetCore.SignalR;

namespace BlazorWASM.Hubs;

public class AnnouncementHub : Hub
{
    public async Task SendMessage(string user, string message)
    {
        await Clients.All.SendAsync("ReceiveMessage", user, message);
    }
}