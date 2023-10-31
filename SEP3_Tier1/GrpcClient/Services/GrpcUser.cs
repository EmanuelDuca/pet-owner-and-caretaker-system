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
    private PetOwnerService.PetOwnerServiceClient petOwnerServiceClient;

    public GrpcUser(PetOwnerService.PetOwnerServiceClient petOwnerServiceClient)
    {
        this.petOwnerServiceClient = petOwnerServiceClient;
    }
    
    public async Task<User> CreateAsync(User user)
    {
        //Should check wich type of user it is
        var request = new PetOwner
        {
            Username = user.Username,
            Password = user.Password,
            Email = user.Email
        };

        PetOwner grpcUserToCreate = petOwnerServiceClient.CreatePetOwner(request);
        Console.WriteLine($"Java returned {grpcUserToCreate.Email} {grpcUserToCreate.Username}");
        return ConvertUserFromGrps(grpcUserToCreate);
    }

    private User ConvertUserFromGrps(PetOwner dto)
    {
        var user = new Domain.Models.PetOwner
        {
            Username = dto.Username,
            Email = dto.Email,
            Password = dto.Password,
            Age = dto.Age,
            Name = dto.Username,
            Type = "PetOwner",
        };
        return user;
    }
    

    public Task<User?> GetByEmailAsync(string email)
    {
        return null;
    }
}