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
    private PetMapper petMapper;

    public GrpcUserService(UserService.UserServiceClient userServiceClient)
    {
        this.userServiceClient = userServiceClient;
        mapper = new UserMapper();
        petMapper = new PetMapper(this);
    }
    
    public async Task<User> CreateAsync(User user)
    {
        try
        {
            UserProto grpcUserToCreate = await userServiceClient.CreateUserAsync(mapper.MapToProto(user));
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
            Console.WriteLine(e.Message);
            throw new Exception(e.Message);
        }
    }

    public async Task<User?> UpdateAsync(User user)
    {
        try
        {
            UserProto grpcUserToCreate = await userServiceClient.UpdateUserAsync(mapper.MapToProto(user));
            Console.WriteLine($"Java returned {grpcUserToCreate.Email} {grpcUserToCreate.Username}");
            return await mapper.MapToEntity(grpcUserToCreate);
        }
        catch (RpcException e)
        {
            throw new Exception(e.Status.Detail);
        }
    }

    public async Task DeleteAsync(string email)
    {
        try
        {
            await userServiceClient.DeleteUserAsync(
                new FindUserProto
                {
                    Email = email
                });
        }
        catch (RpcException e)
        {
            throw new Exception(e.Status.Detail);
        }
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
    
    

    public async Task<IEnumerable<Pet>> GetPetsOfUserAsync(string email)
    {
        try
        { 
            PetsProto pets = await userServiceClient.SearchPetsAsync(new FindUserProto()
            {
                Email = email
            });
            return await petMapper.MapToEntityList(pets);
        }
        catch (RpcException e)
        {
            throw new Exception(e.Status.Detail);
        }
    }

    public async Task<User> LoginAsync(string email, string password)
    {
        try
        {
            var userProto = await userServiceClient.LogInAsync(new LoginUserProto()
            {
                Email = email,
                Password = password
            });

            return await mapper.MapToEntity(userProto);
        }
        catch (RpcException e)
        {
            Console.WriteLine(e);
            throw new Exception(e.Status.Detail);
        }
    }
}