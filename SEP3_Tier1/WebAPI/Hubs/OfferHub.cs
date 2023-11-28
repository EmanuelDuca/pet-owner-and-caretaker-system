using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.SignalR;

namespace WebAPI;

// [Authorize]
public class OfferHub : Hub
{
    public async Task SendMessage(string user, string message)
    {
        await Clients.All.SendAsync("Test", user, message);
    }
}