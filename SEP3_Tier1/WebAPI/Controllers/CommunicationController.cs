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
}