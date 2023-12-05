using Domain.DTOs;
using Domain.Models;

namespace Application.LogicInterface;

public interface IUserLogic
{
    Task<User> RegisterAsync(UserCreationDto creationDto);
    Task<User> LoginAsync(UserLoginDto loginDto);
    Task<User> EditAsync(UserEditDto editDto);
    Task DeleteUser(string email);
    Task<IEnumerable<User>> GetAsync(SearchUsersDto parameters);

    Task<IEnumerable<Pet>> GetPetsOfUserAsync(string email);
}