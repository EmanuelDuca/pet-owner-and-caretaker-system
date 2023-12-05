using Application.LogicInterface;
using Domain.DTOs;
using Domain.Models;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;

namespace WebAPI.Controllers;

[ApiController]
[Route("announcements")]
public class AnnouncementController : ControllerBase
{
    private readonly IAnnouncementLogic logic;

    public AnnouncementController(IAnnouncementLogic logic)
    {
        this.logic = logic;
    }

    [HttpPost]
    public async Task<ActionResult<Announcement>> CreateAnnouncement(CreateAnnouncementDto dto)
    {
        try
        {
            Announcement announcement = await logic.CreateAsync(dto);
            return Created($"/announcements/{announcement.Id}", announcement);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(404, e.Message);
        }
    }
    

    [HttpGet("{id:int}")]
    public async Task<ActionResult<Announcement>> GetByIdAsync([FromRoute] int id)
    {
        try
        {
            var announcement = await logic.GetByIdAsync(id);
            return Ok(announcement);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
    
    [HttpPost("filter")]
    public async Task<ActionResult> GetAnnouncementsByPreferenceAsync([FromBody] SearchAnnouncementDto dto)
    {
        try
        {
            var announcements = await logic.GetAsync(dto);
            return Ok(announcements);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }

    [HttpPatch]
    public async Task<ActionResult> UpdateAsync([FromBody] UpdateAnnouncementDto dto)
    {
        try
        {
            await logic.UpdateAsync(dto);
            return Ok();
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
    
    [HttpDelete("{id:int}")]
    public async Task<ActionResult> DeleteAsync([FromRoute] int id)
    {
        try
        {
            await logic.DeleteAsync(id);
            return Ok();
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
}