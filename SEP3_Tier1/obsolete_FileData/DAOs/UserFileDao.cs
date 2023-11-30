using System.Linq;
using System.Threading.Tasks;
using Application.DaoInterface;
using Domain.DTOs;
using Domain.Models;

namespace obsolete_FileData.DAOs;

public class UserFileDao : IUserDao
{
    private readonly FileContext context;

    public UserFileDao(FileContext context)
    {
        this.context = context;
    }
    public Task<User> CreateAsync(User user)
    {
        context.Users.Add(user);
        context.SaveChanges();

        return Task.FromResult(user);
    }

    public Task<User?> GetByEmailAsync(string email)
    {
        User? existing = context.Users.FirstOrDefault(u =>
            u.Email.Equals(email));
        return Task.FromResult(existing);
    }

    public Task<User?> UpdateAsync(User user)
    {
        User? existing = context.Users.FirstOrDefault(u =>
            u.Email.Equals(user.Email));
        if (existing == null)
        {
            throw new Exception($"User with email: {user.Email} does not exist!");
        }

        User updatedUser = new User
        {
            Email = existing.Email,
            Password = user.Password,
            Username = user.Username,
            Age = user.Age ?? existing.Age,
            PhoneNumber = user.PhoneNumber ?? existing.PhoneNumber,
            Type = existing.Type
        };

        context.Users.Remove(existing);
        context.Users.Add(updatedUser);
        
        context.SaveChanges();

        return Task.FromResult(updatedUser);
    }

    public Task DeleteAsync(string email)
    {
        User? existing = context.Users.FirstOrDefault(u =>
            u.Email.Equals(email));
        if (existing == null)
        {
            throw new Exception($"User with email: {email} does not exist!");
        }
        
        context.Users.Remove(existing);
        context.SaveChanges();
        
        return Task.CompletedTask;
    }

    public Task<IEnumerable<User>> GetAsync(SearchUsersDto parameters)
    {
        throw new NotImplementedException();
    }
}