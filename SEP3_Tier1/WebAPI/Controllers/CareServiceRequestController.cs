using Application.DaoInterface;
using Application.LogicInterface;
using Domain.DTOs;
using Domain.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.SignalR;

namespace WebAPI.Controllers;

[ApiController]
[Route("care_service")]
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
    
    [HttpPatch("offer/accept")]
    public async Task<ActionResult> AcceptOffer([FromBody] int requestId)
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
    
    [HttpPatch("offer/deny")]
    public async Task<ActionResult> DenyOffer([FromBody] int requestId)
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
    
    [HttpPost("service/end")]
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
    public async Task<ActionResult> GetServiceAsync([FromQuery] int serviceId)
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
    [HttpDelete("feedback/{serviceId:int}&{email}")]
    public async Task<ActionResult> DeleteFeedbackAsync([FromRoute] int serviceId, [FromRoute] string email)
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
    [HttpGet("feedback/{email}")]
    public async Task<ActionResult> GetFeedbacks([FromRoute] string email)
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
    
    
    // Even though the endpoint should be GET, when query parameters number is to big, it's better to switch to POST which has a body that is easier to user
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