using System.Security.Claims;
using Domain.DTOs;
using Domain.Models;

namespace HttpClients.ClientInterfaces;

public interface IAuthService
{
    Task LoginAsync(UserLoginDto loginDto);
    Task LogoutAsync();
    Task RegisterAsync(UserCreationDto registrationDto);
    Task<ClaimsPrincipal> GetAuthAsync();
    Task EditProfile(UserEditDto dto);
    Task DeleteProfile(string email);
    Action<ClaimsPrincipal> OnAuthStateChanged { get; set; }
}