using System.Security.Claims;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.SignalR;

namespace WebAPI;

[Authorize]
public class MyHub : Hub<IMyClient>
{
    public override async Task OnConnectedAsync()
    {
        await Clients.Client(Context.ConnectionId).Receive("test",$"Thanks, {Context.User?.Identity.Name}");

        await base.OnConnectedAsync();
    }
}

public interface IMyClient
{
    Task Receive(string user, string message);
}