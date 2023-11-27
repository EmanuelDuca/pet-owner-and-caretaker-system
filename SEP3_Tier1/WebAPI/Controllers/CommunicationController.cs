using Application.DaoInterface;
using Domain.DTOs;
using Microsoft.AspNetCore.Mvc;

namespace WebAPI.Controllers;

[ApiController]
[Route("communication")]
public class CommunicationController : ControllerBase
{
    private readonly ICommunicationLogic logic;

    public CommunicationController(ICommunicationLogic logic)
    {
        this.logic = logic;
    }

    [HttpGet]
    public async Task<ActionResult> GetAsync(SearchCaretakerDto parameters)
    {
        try
        {
            var caretakers = await logic.GetAsync(parameters);
            return Ok(caretakers);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
}