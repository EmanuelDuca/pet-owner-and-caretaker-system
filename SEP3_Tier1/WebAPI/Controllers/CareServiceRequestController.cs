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
    public async Task<ActionResult> OfferCare(CreateOfferCareDto dto)
    {
        try
        {
            await logic.OfferCare(dto);
            // _hubContext.Clients.All.SendAsync("ReceiveMessage", "Change made");
            return Ok();
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
    
    [HttpPost("accept")]
    public async Task<ActionResult> AcceptOffer(int requestId)
    {
        try
        {
            await logic.AcceptOffer(requestId);
            // _hubContext.Clients.All.SendAsync("ReceiveMessage", "Change made");
            return Ok();
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
    
    [HttpPost("end")]
    public async Task<ActionResult> EndOffer(int serviceId)
    {
        try
        {
            await logic.AcceptOffer(serviceId);
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