using Application.LogicInterface;
using Domain.DTOs;
using Domain.Models;
using Microsoft.AspNetCore.Mvc;

namespace WebAPI.Controllers;

[ApiController]
[Route("announcements")]
public class AnnouncementController: ControllerBase
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
}