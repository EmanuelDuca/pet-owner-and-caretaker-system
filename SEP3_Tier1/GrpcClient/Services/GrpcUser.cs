using Application.DaoInterface;
using Domain.Models;

namespace GrpcClient.Services;
using Domain.DTOs;
using Grpc.Core;
using Grpc.Net.Client;
using GrpcClient;
using Microsoft.AspNetCore.Mvc;

public class GrpcUser : BackgroundService, IUserDao
{
    private readonly ILogger<GrpcUser> logger;
    private readonly string url;
    
    public GrpcUser(ILogger<GrpcUser> logger, IConfiguration configuration)
    {
        this.logger = logger;
        url = configuration["Kestrel:Endpoints:gRPC:Url"];
    }
    
    protected override async Task ExecuteAsync(CancellationToken stoppingToken)
    {
        using var channel = GrpcChannel.ForAddress(url);
        var client = new AnnouncementService.AnnouncementServiceClient(channel);
        while (!stoppingToken.IsCancellationRequested)
        {
            var reply = client.CreateAnnouncement(new Announcement
            {
                PetOwnerUsername = "ionV",
                Description = "some description",
                TimeInterval = new TimeInterval
                {
                    StartDate = "12/10/2023",
                    FinishDate = "28/10/2023"
                },
                Pet = new Pet
                {
                    PetName = "Max",
                    PetType = "dog",
                    Weight = 15,
                    IsVaccinated = true,
                    Description = "some description",
                },
                PostalCode = "8700", 
                DateOfCreation = "10/10/2023 16:00"
            });
            
            logger.LogInformation("AnnouncementService: {reply.Message} -- {DateTime.now}");
            await Task.Delay(1000, stoppingToken);
        }
    }

    public Task<User> CreateAsync(User user)
    {
        try
        {
            // Create a channel to the gRPC server
            var channel = GrpcChannel.ForAddress(url);
            // Create a client for your service
            var client = new PetOwnerService.PetOwnerServiceClient(channel);
            
            // Use the client to make gRPC call
            var request = new PetOwner
            {
                Username = user.Username,
                Password = user.Password,
                Email = user.Email
            };
            var response = client.CreatePetOwner(request);
            User petOwner = new Domain.Models.PetOwner
            {
                Username = response.Username,
                Password = response.Password,
                Email = response.Email,
                Age = response.Age
            };
            Console.WriteLine($"Server says: {response.Email}");
            return Task.FromResult(petOwner);
        }
        catch (Exception e)
        {
            Console.WriteLine(e.Message);
            throw e;
        }
    }
    
    public Task CreateAnnouncement(AnnouncementCreationDto dto)
    {
        try
        {
            // Create a channel to the gRPC server
            var channel = GrpcChannel.ForAddress(url);
            // Create a client for your service
            var client = new AnnouncementService.AnnouncementServiceClient(channel);
            
            // Use the client to make gRPC calls
            var request = new Announcement
            {
                PetOwnerUsername = dto.OwnerEmail,
                Description = "some description",
                TimeInterval = new TimeInterval
                {
                    StartDate = "12/10/2023",
                    FinishDate = "28/10/2023"
                },
                Pet = new Pet
                {
                    PetName = "Max",
                    PetType = "dog",
                    Weight = 15,
                    IsVaccinated = true,
                    Description = "some description",
                },
                PostalCode = "8700", 
                DateOfCreation = "10/10/2023 16:00"
            };
            var response = client.CreateAnnouncement(request);
            Console.WriteLine($"Server says: {response.Description}");
            return Task.CompletedTask;
        }
        catch (Exception e)
        {
            Console.WriteLine(e.Message);
            return Task.FromException(e);
        }
    }

    public Task<User?> GetByEmailAsync(string email)
    {
        throw new NotImplementedException();
    }
}