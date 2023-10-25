using Application.DaoInterface;
using Application.LogicInterface;
using Domain.DTOs;
using Domain.Models;

namespace Application.Logic;

public class UserLogic : IUserLogic
{
    private readonly IUserDao userDao;

    public UserLogic(IUserDao userDao)
    {
        this.userDao = userDao;
    }

    public async Task<User> CreateAsync(UserCreationDto dto)
    {
        User? existing = await userDao.GetByEmail(dto.Email);
        if (existing != null) {
            throw new Exception("Email already taken");
        }

        User toCreate;
        switch (dto.Type)
        {
            case "PetOwner":
                toCreate = new PetOwner()
                {
                    UserName = dto.UserName,
                    Email = dto.Email,
                    Password = dto.Password,
                    Type = dto.Type
                };
                break;
            case "CareTaker":
                toCreate = new CareTaker()
                {
                    UserName = dto.UserName,
                    Email = dto.Email,
                    Password = dto.Password,
                    Type = dto.Type
                };
                break;
            default:
                throw new Exception("Wrong user type");
        }
        
        User created = await userDao.Create(toCreate);
        return created;
    }
}