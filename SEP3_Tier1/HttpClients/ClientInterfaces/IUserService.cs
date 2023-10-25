using Domain.Models;

namespace HttpClients.ClientInterfaces;

public interface IUserService
{
    Task<IEnumerable<User>> GetAsync();
}