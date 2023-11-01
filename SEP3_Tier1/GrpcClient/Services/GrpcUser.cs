using Application.DaoInterface;
using Domain.Models;

namespace GrpcClient.Services;
using Domain.DTOs;
using Grpc.Core;
using Grpc.Net.Client;
using GrpcClient;
using Microsoft.AspNetCore.Mvc;

public class GrpcUser : IUserDao
{
    private UserService.UserServiceClient userServiceClient;

    public GrpcUser(UserService.UserServiceClient userServiceClient)
    {
        this.userServiceClient = userServiceClient;
    }
    
    public async Task<Domain.Models.User> CreateAsync(Domain.Models.User user)
    {
        string type = "";
        //Should check wich type of user it is
        if (user is Domain.Models.PetOwner)
        {
            type = "PetOwner";
        }else if (user is CareTaker)
        {
            type = "CareTaker";
        }
        
        var request = new User
        {
            Username = user.Username,
            Password = user.Password,
            Email = user.Email,
            Age = user.Age.HasValue ? user.Age.Value : 200,
            Phone = user.PhoneNumber,
            Type = type
        };
        
        User grpcUserToCreate = userServiceClient.CreatUser(request);
        Console.WriteLine($"Java returned {grpcUserToCreate.Email} {grpcUserToCreate.Username}");
        return ConvertUserFromGrps(grpcUserToCreate);
    }
    
    private Domain.Models.User ConvertUserFromGrps(User dto)
    {
        Domain.Models.User user;
        switch (dto.Type)
        {
            case "PetOwner":
                user = new Domain.Models.PetOwner
                {
                    Username = dto.Username,
                    Email = dto.Email,
                    Password = dto.Password,
                    Age = dto.Age,
                    Name = dto.Username,
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
                };
                break;
            default:
                user = new Domain.Models.PetOwner
                {
                    Username = "Demo User",
                    Email = "demo",
                    Password = "demo",
                    Age = 20,
                    Name = "demo"
                };
                break;
        }
        return user;
    }
    

    public Task<Domain.Models.User?> GetByEmailAsync(string email)
    {
        return null;
    }
}