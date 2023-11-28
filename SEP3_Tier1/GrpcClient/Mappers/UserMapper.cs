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

    public async Task<IEnumerable<User>> MapToEntityList(UsersProto proto)
    {
        return await Task.WhenAll(proto.Users
            .Select(async user => await MapToEntity(user)));
    }
    
    public static UserProto UserProtoGenerator(User user)
    {
        string type = "";
        if (user is PetOwner)
        {
            type = "PetOwner";
        }else if (user is CareTaker)
        {
            type = "CareTaker";
        }
        
        var request = new UserProto
        {
            Username = user.Username,
            Password = user.Password,
            Email = user.Email,
            Type = type,
            Age = user.Age!.Value,
            Phone = user.PhoneNumber
        };
        return request;
    }
}