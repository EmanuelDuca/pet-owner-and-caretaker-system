using Domain.DTOs;
using Domain.Models;

namespace Application.DaoInterface;

public interface IUserDao
{
    Task<User> CreateAsync(User user);
    Task<User?> GetByEmailAsync(string email);
    Task<User?> UpdateAsync(User user);
}