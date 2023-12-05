using Application.DaoInterface;
using Domain;
using Domain.Models;
using GrpcClient.Mappers;
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
    private UserMapper mapper;

    public GrpcUserService(UserService.UserServiceClient userServiceClient)
    {
        this.userServiceClient = userServiceClient;
        mapper = new UserMapper();
    }
    
    public async Task<User> CreateAsync(User user)
    {
        try
        {
            // string type = "";
            // if (user is PetOwner)
            // {
            //     type = "PetOwner";
            // }else if (user is CareTaker)
            // {
            //     type = "CareTaker";
            // }
            //
            // var request = new UserProto
            // {
            //     Username = user.Username,
            //     Password = user.Password,
            //     Email = user.Email,
            //     Type = type
            // };
        
            UserProto grpcUserToCreate = await userServiceClient.CreateUserAsync(UserProtoGenerator(user));
            Console.WriteLine($"Java returned {grpcUserToCreate.Email} {grpcUserToCreate.Username}");
            return await mapper.MapToEntity(grpcUserToCreate);
        }
        catch (RpcException e)
        {
            throw new Exception(e.Status.Detail);
        }
    }

    public async Task<User?> GetByEmailAsync(string email)
    {
        try
        {
            UserProto receivedUser = await userServiceClient.FindUserAsync(new FindUserProto
            {
                Email = email
            });
            return await mapper.MapToEntity(receivedUser);
        }
        catch (RpcException e)
        {
            throw new Exception(e.Message);
        }
    }

    public async Task<User?> UpdateAsync(User user)
    {
        try
        {
            UserProto grpcUserToCreate = await userServiceClient.UpdateUserAsync(UserProtoGenerator(user));
            Console.WriteLine($"Java returned {grpcUserToCreate.Email} {grpcUserToCreate.Username}");
            return await mapper.MapToEntity(grpcUserToCreate);
        }
        catch (RpcException e)
        {
            throw new Exception(e.Status.Detail);
        }
    }

    public Task DeleteAsync(string email)
    {
        throw new NotImplementedException();
    }

    private UserProto UserProtoGenerator(User user)
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
        return request;
    }
    
    public async Task<IEnumerable<User>> GetAsync(SearchUsersDto parameters)
    {
        try
        {
            var request = new SearchUsersProto()
            {
                Age = parameters.Age,
                Name = parameters.Name,
                Type = parameters.Type
            };
            UsersProto users = await userServiceClient.SearchUsersAsync(request);
            return await mapper.MapToEntityList(users);
        }
        catch (RpcException e)
        {
            throw new Exception(e.Status.Detail);
        }
    }
}