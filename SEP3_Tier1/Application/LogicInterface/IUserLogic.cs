using Domain.DTOs;
using Domain.Models;

namespace Application.LogicInterface;

public interface IUserLogic
{
    Task<User> CreateAsync(UserCreationDto userToCreate);
}