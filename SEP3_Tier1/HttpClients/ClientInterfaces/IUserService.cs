using System.Security.Claims;
using Domain.DTOs;
using Domain.Models;

namespace HttpClients.ClientInterfaces;

public interface IUserService
{
    Task EditProfile(UserEditDto dto);
    Task DeleteProfile(string email);
    Task<IEnumerable<User>> GetUsers(SearchUsersDto dto);
    Task<IEnumerable<Pet>> GetPetsOfUser(string userEmail);
}