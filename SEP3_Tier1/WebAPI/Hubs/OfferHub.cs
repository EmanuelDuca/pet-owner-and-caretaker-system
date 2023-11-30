using System.Security.Claims;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.SignalR;

namespace WebAPI;

[Authorize]
public class OfferHub : Hub<IOfferClient>
{
    private int count = 0;
    public async Task SendMessage(string user, string message)
    {
        // await Clients.All.Receive("New",$"Thanks, {Context.UserIdentifier.ToString()}, though {Context.User.Claims.FirstOrDefault(c => c.Type == ClaimTypes.NameIdentifier)}");
        // await Clients.All.SendAsync("New", user, message);
        await Clients.User("cubeco").Receive("lol", message);
        // await Clients.Client(Context.ConnectionId)
    }
    
    public async Task SendOffer()
    {
        // await Clients.All.Receive("New",$"Thanks, {Context.UserIdentifier.ToString()}, though {Context.User.Claims.FirstOrDefault(c => c.Type == ClaimTypes.NameIdentifier)}");
        // await Clients.All.SendAsync("New", user, message);
        await Clients.All.Notify(++count);
        // await Clients.Client(Context.ConnectionId)
    }
}

public interface IOfferClient
{
    Task Receive(string user, string message);
    Task Notify(int numberOfOffers);

}