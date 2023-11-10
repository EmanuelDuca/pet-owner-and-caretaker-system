using Application.LogicInterface;
using Domain.DTOs;
using Domain.Models;
using Microsoft.AspNetCore.Mvc;

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
    public async Task<ActionResult<Announcement>> CreateAnnouncement(AnnouncementCreationDto creationDto)
    {
        try
        {
            Announcement announcement = await logic.CreateAsync(creationDto);
            return Created($"/announcements/{announcement.Id}", announcement);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(404, e.Message);
        }
    }

    [HttpGet]
    public async Task<ActionResult> GetAsync([FromQuery] string? startTime, [FromQuery] string? endTime,
        [FromQuery] string? description, [FromQuery] string? postalCode, [FromQuery] IEnumerable<PetType.Type> types)
    {
        try
        {
            SearchAnnouncementDto parameters = new SearchAnnouncementDto
            {
                StartTime = startTime,
                EndTime = endTime,
                DescriptionContains = description,
                PostalCode = postalCode,
                PetTypes = types
            };
            var announcements = await logic.GetAsync(parameters);
            return Ok(announcements);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }

    [HttpPatch]
    public async Task<ActionResult> UpdateAsync([FromBody] AnnouncementUpdateDto dto)
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