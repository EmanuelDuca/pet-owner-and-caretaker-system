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

    public async Task<User> RegisterAsync(UserCreationDto dto)
    {
        User? existing = await userDao.GetByEmailAsync(dto.Email);
        if (existing != null) {
            throw new Exception("Email already taken");
        }

        
        User toCreate;
        switch (dto.Type)
        {
            case "PetOwner":
                toCreate = new PetOwner()
                {
                    Username = dto.UserName,
                    Email = dto.Email,
                    Password = dto.Password,
                    Type = dto.Type
                };
                break;
            case "CareTaker":
                toCreate = new CareTaker()
                {
                    Username = dto.UserName,
                    Email = dto.Email,
                    Password = dto.Password,
                    Type = dto.Type
                };
                break;
            default:
                throw new Exception("Wrong user type");
        }
        
        User created = await userDao.CreateAsync(toCreate);
        return created;
    }

    public async Task<User> LoginAsync(UserLoginDto loginDto)
    {
        User? existing = await userDao.GetByEmailAsync(loginDto.Email);
        if (existing is null)
            throw new Exception("Wrong email, user not found.");

        if (!loginDto.Password.Equals(existing.Password))
            throw new Exception("Wrong password or email.");

        return existing;
    }

    public async Task<User> EditAsync(UserEditDto editDto)
    {
        User? existing = await userDao.GetByEmailAsync(editDto.Email);
        if (existing == null) {
            throw new Exception("User with given email does not exist");
        }
        
        
        User tempUser = new User()
        {
            Username = editDto.UserName ?? existing.Username,
            Email = existing.Email,
            Password = editDto.Password ?? existing.Password,
            Type = existing.Type,
            PhoneNumber = editDto.PhoneNumber ?? existing.PhoneNumber,
            Age = editDto.Age ?? existing.Age,
            Name = editDto.Name ?? existing.Name
        };
        User toUpdate;
        switch (existing.Type)
        {
            case "PetOwner":
                toUpdate = new PetOwner(tempUser);
                break;
            case "CareTaker":
                toUpdate = new CareTaker(tempUser);
                break;
            default:
                throw new Exception("Wrong user type");
        }
        
        User updated = await userDao.UpdateAsync(toUpdate) ?? throw new Exception("In userLogic file User.Type was mismatched");
        return updated;
    }
    
    public async Task<IEnumerable<User>> GetAsync(SearchUsersDto parameters)
    {
        return await userDao.GetAsync(parameters);
    }
}