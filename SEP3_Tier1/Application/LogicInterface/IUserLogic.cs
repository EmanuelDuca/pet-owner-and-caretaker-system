using Domain.DTOs;
using Domain.Models;

namespace Application.LogicInterface;

public interface IUserLogic
{
    Task<User> RegisterAsync(UserCreationDto creationDto);
    Task<User> LoginAsync(UserLoginDto loginDto);
}