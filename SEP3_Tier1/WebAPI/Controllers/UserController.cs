using System;
using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Text;
using System.Threading.Tasks;
using Application.LogicInterface;
using Domain.DTOs;
using Domain.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.IdentityModel.Tokens;

namespace WebAPI.Controllers;

[ApiController]
[Route("users")]
public class UserController : ControllerBase
{
    private readonly IConfiguration config;
    private readonly IUserLogic userLogic;

    public UserController(IConfiguration config, IUserLogic userLogic)
    {
        this.config = config;
        this.userLogic = userLogic;
    }

    private List<Claim> GenerateClaims(User user)
    {
        var claims = new[]
        {
            new Claim(JwtRegisteredClaimNames.Sub, config["Jwt:Subject"]),
            new Claim(JwtRegisteredClaimNames.Jti, Guid.NewGuid().ToString()),
            new Claim(JwtRegisteredClaimNames.Iat, DateTime.UtcNow.ToString()),
            new Claim(ClaimTypes.Name, user.Username),
            new Claim("Email", user.Email),
            new Claim("Password", user.Password),
            new Claim("RealName", user.Name ?? string.Empty),
            new Claim("Age", user.Age.ToString() ?? string.Empty),
            new Claim("PhoneNumber", user.PhoneNumber ?? string.Empty)
        };

        return claims.ToList();
    }

    private string GenerateJwt(User user)
    {
        List<Claim> claims = GenerateClaims(user);

        SymmetricSecurityKey key = new SymmetricSecurityKey(Encoding.UTF8.GetBytes(config["Jwt:Key"]));
        SigningCredentials signIn = new SigningCredentials(key, SecurityAlgorithms.HmacSha512);

        JwtHeader header = new JwtHeader(signIn);

        JwtPayload payload = new JwtPayload(
            config["Jwt:Issuer"],
            config["Jwt:Audience"],
            claims,
            null,
            DateTime.UtcNow.AddMinutes(60));

        JwtSecurityToken token = new JwtSecurityToken(header, payload);

        string serializedToken = new JwtSecurityTokenHandler().WriteToken(token);
        return serializedToken;
    }

    [HttpPost, Route("register")]
    public async Task<ActionResult<User>> Register([FromBody] UserCreationDto dto)
    {
        try
        {
            User user = await userLogic.RegisterAsync(dto);
            return Ok(GenerateJwt(user));
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.StackTrace);
        }
    }
    
    [HttpPost("login")]
    public async Task<ActionResult<User>> Login([FromBody] UserLoginDto dto)
    {
        try
        {
            User user = await userLogic.LoginAsync(dto);
            return Ok(GenerateJwt(user));
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
}