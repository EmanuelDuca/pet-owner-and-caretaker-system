using Application.DaoInterface;
using Grpc.Net.Client;
using Domain.Models;

namespace GrpcClient.Services;
using Domain.DTOs;
using Grpc.Core;
using Grpc.Net.Client;
using GrpcClient;

public class GrpcLogic : IAnnouncementDao
{
    public Task<Domain.Models.Announcement> CreateAsync(Domain.Models.Announcement announcement)
    {
        try
        {
            using var channel = GrpcChannel.ForAddress("https://localhost:5001");
            var client = new AnnouncementService.AnnouncementServiceClient(channel);

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
            Console.WriteLine(reply);
            Domain.Models.Announcement announce = new Domain.Models.Announcement
            {
                Id = reply.Id,
                CreationDateTime = DateTime.Parse(reply.DateOfCreation),
                EndDate = DateTime.Parse(reply.TimeInterval.FinishDate),
                petOwner = new Domain.Models.PetOwner
                {
                    Email = "defaul@gmai.com",
                    Password = "1111",
                    Username = "defaultUser"
                },
                PostalCode = reply.PostalCode,
                ServiceDescription = reply.Description,
                StartDate = DateTime.Parse(reply.TimeInterval.StartDate)
            };

            return Task.FromResult(announce);
        }
        catch (Exception e)
        {
            throw e;
        }
        
        
    }
}
    

    