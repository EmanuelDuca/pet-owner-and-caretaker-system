using Application.DaoInterface;
using Application.LogicInterface;
using Domain.DTOs;
using Domain.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.SignalR;

namespace WebAPI.Controllers;

[ApiController]
[Route("communication")]
public class CareServiceRequestController : ControllerBase
{
    private readonly ICareServiceRequestLogic logic;
    
    // private readonly IHubContext<AnnouncementHub> _hubContext;

    // public CommunicationController(IHubContext<AnnouncementHub> hubContext, ICommunicationLogic logic)
    // {
    //     _hubContext = hubContext;
    //     this.logic = logic;
    // }
    
    [HttpPost("offer")]
    public async Task<ActionResult> OfferCare(string initiatorEmail, int announcementId, string recipientEmail)
    {
        try
        {
            await logic.OfferCare(initiatorEmail, announcementId, recipientEmail);
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