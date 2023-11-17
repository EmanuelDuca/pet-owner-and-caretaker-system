using Domain.Models;

namespace GrpcClient.Mappers;

public class UserMapper
{
    public Task<User> MapToEntity(UserProto dto)
    {
        User user;
        switch (dto.Type)
        {
            case "PetOwner":
                user = new PetOwner()
                {
                    Username = dto.Username,
                    Email = dto.Email,
                    Password = dto.Password,
                    Age = dto.Age,
                    Name = dto.Username,
                    Type = dto.Type,
                    PhoneNumber = dto.Phone
                };
                break;
            case "CareTaker":
                user = new CareTaker
                {
                    Username = dto.Username,
                    Email = dto.Email,
                    Password = dto.Password,
                    Age = dto.Age,
                    Name = dto.Username,
                    Type = dto.Type,
                    PhoneNumber = dto.Phone
                };
                break;
            default:
                user = new PetOwner
                {
                    Username = "Demo User",
                    Email = "demo",
                    Password = "demo",
                    Age = 20,
                    Name = "demo"
                };
                break;
        }
        return Task.FromResult(user);
    }
}