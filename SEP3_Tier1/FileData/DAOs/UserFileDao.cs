using System.Linq;
using System.Threading.Tasks;
using Application.DaoInterface;
using Domain.Models;

namespace FileData.DAOs;

public class UserFileDao : IUserDao
{
    private readonly FileContext context;

    public UserFileDao(FileContext context)
    {
        this.context = context;
    }
    public Task<User> Create(User user)
    {
        context.Users.Add(user);
        context.SaveChanges();

        return Task.FromResult(user);
    }

    public Task<User?> GetByEmail(string email)
    {
        User? existing = context.Users.FirstOrDefault(u =>
            u.Email.Equals(email));
        return Task.FromResult(existing);
    }
}