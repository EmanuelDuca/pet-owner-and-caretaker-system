using Application.DaoInterface;
using Domain.DTOs;
using Domain.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.SignalR;

namespace WebAPI.Controllers;

[ApiController]
[Route("communication")]
public class CommunicationController : ControllerBase
{
    private readonly ICommunicationLogic logic;
    
    // private readonly IHubContext<AnnouncementHub> _hubContext;

    // public CommunicationController(IHubContext<AnnouncementHub> hubContext, ICommunicationLogic logic)
    // {
    //     _hubContext = hubContext;
    //     this.logic = logic;
    // }
    
    [HttpPost("offer")]
    public async Task<ActionResult> OfferCare(CareTaker caretaker)
    {
        try
        {
            await logic.OfferCare(caretaker);
            // _hubContext.Clients.All.SendAsync("ReceiveMessage", "Change made");
            return Ok();
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
}