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

    public CareServiceRequestController(/*IHubContext<AnnouncementHub> hubContext,*/ ICareServiceRequestLogic logic)
    {
        // _hubContext = hubContext;
        this.logic = logic;
    }
    
    [HttpPost("offer")]
    public async Task<ActionResult> OfferCare([FromBody] CreateOfferCareDto dto)
    {
        try
        {
            Console.WriteLine(dto);
            await logic.OfferCare(dto);
            // _hubContext.Clients.All.SendAsync("ReceiveMessage", "Change made");
            return Ok();
        }
        catch (Exception e)
        {
            Console.WriteLine(e.StackTrace);
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
    
    [HttpPost("deny")]
    public async Task<ActionResult> DenyOffer(int requestId)
    {
        try
        {
            await logic.DenyOffer(requestId);
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
            await logic.EndOffer(serviceId);
            return Ok();
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
    
    // GetRequestsAsync
    [HttpGet("requests/{announcementId:int}")]
    public async Task<ActionResult<IEnumerable<ServiceRequest>>> GetRequestsAsync(int announcementId)
    {
        try
        {
            var services = await logic.GetRequestsAsync(announcementId);
            return Ok(services);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
    
    // GetServiceAsync
    [HttpGet("service/{serviceId:int}")]
    public async Task<ActionResult> GetServiceAsync([FromBody] int serviceId)
    {
        try
        {
            var service = await logic.GetServiceAsync(serviceId);
            return Ok(service);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
    
    // AddFeedbackAsync
    [HttpPost("feedback")]
    public async Task<ActionResult> AddFeedbackAsync([FromBody] Feedback feedback)
    {
        try
        {
            await logic.AddFeedbackAsync(feedback);
            return Ok();
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
    
    // DeleteFeedbackAsync
    [HttpDelete("feedback/{serviceId:int}&{email:int}")]
    public async Task<ActionResult> DeleteFeedbackAsync([FromBody] int serviceId, string email)
    {
        try
        {
            await logic.DeleteFeedbackAsync(serviceId, email);
            return Ok();
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
    
    // GetFeedbacks
    [HttpGet("feedback")]
    public async Task<ActionResult> GetFeedbacks([FromQuery] string email)
    {
        try
        {
            var feedbacks = await logic.GetFeedbacks(email);
            return Ok(feedbacks);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
    
    // GetServicesAsync
    [HttpPost("services")]
    public async Task<ActionResult> GetServicesAsync([FromBody] SearchServicesDto dto)
    {
        try
        {
            var services = await logic.GetServicesAsync(dto);
            // _hubContext.Clients.All.SendAsync("ReceiveMessage", "Change made");
            return Ok(services);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
}