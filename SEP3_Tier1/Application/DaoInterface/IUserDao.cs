using Domain.Models;

namespace Application.DaoInterface;

public interface IUserDao
{
    Task<User> Create(User user);
    Task<User?> GetByEmail(string email);
}