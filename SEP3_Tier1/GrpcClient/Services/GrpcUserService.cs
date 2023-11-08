using Application.DaoInterface;
using Domain;
using Domain.Models;
using HttpClients.ClientInterfaces;

namespace GrpcClient.Services;
using Domain.DTOs;
using Grpc.Core;
using Grpc.Net.Client;
using GrpcClient;
using Microsoft.AspNetCore.Mvc;

public class GrpcUserService : IUserDao
{
    private UserService.UserServiceClient userServiceClient;

    public GrpcUserService(UserService.UserServiceClient userServiceClient)
    {
        this.userServiceClient = userServiceClient;
    }
    
    public async Task<User> CreateAsync(User user)
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
            Type = type
        };
        
        UserProto grpcUserToCreate = userServiceClient.CreateUser(request);
        Console.WriteLine($"Java returned {grpcUserToCreate.Email} {grpcUserToCreate.Username}");
        return await ConvertUserFromGrps(grpcUserToCreate);
    }
    
    private Task<User> ConvertUserFromGrps(UserProto dto)
    {
        User user;
        switch (dto.Type)
        {
            case "PetOwner":
                user = new PetOwner
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
    

    public async Task<User?> GetByEmailAsync(string email)
    {
        SearchUserDto searchDto = new SearchUserDto(email);
        // string query = await HttpClientHelper.ConstructQuery(searchDto);
        UserProto receivedUser = await userServiceClient.FindUserAsync(new FindUserProto
        {
            Email = email
        });
        
        return await ConvertUserFromGrps(receivedUser);
    }
}