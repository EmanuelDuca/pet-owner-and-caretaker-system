using System.Globalization;
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
    private AnnouncementService.AnnouncementServiceClient announcementServiceClient;

    public GrpcLogic(AnnouncementService.AnnouncementServiceClient announcementServiceClient)
    {
        this.announcementServiceClient = announcementServiceClient;
    }

    public Task<AnnouncementCreationDto> CreateAsync(AnnouncementCreationDto dto)
    {
        Console.WriteLine($"Print DateOfCreation Before {dto.CreationDateTime.ToShortDateString()}");
        var request = new Announcement
        {
            PetOwnerEmail = dto.OwnerEmail,
            Description = dto.ServiceDescription,
            TimeInterval = new TimeInterval
            {
                StartDate = dto.StartDate.ToShortDateString(),
                FinishDate = dto.EndDate.ToShortDateString()
            },
            Pet = new Pet
            {
                PetName = dto.Pet.PetName,
                PetType = dto.Pet.PetType,
                Weight = dto.Pet.Weight,
                IsVaccinated = dto.Pet.IsVaccinated,
                Description = dto.Pet.Description,
            },
            PostalCode = dto.PostalCode,
            DateOfCreation = dto.CreationDateTime.ToShortDateString()
        };
        
        Announcement grpcAnnouncementToCreate = announcementServiceClient.CreateAnnouncement(request);
        PrintAnnouncement(grpcAnnouncementToCreate);
        Console.WriteLine($"Java returned new Announcement made by {grpcAnnouncementToCreate.PetOwnerEmail}");

        return Task.FromResult(ConvertAnnouncementFromGrpc(grpcAnnouncementToCreate));

    }


    private AnnouncementCreationDto ConvertAnnouncementFromGrpc(Announcement dto)
    {
        Console.WriteLine($"Date of Creation it is[{dto.DateOfCreation}]");

        var announcement = new AnnouncementCreationDto
        {
            Id = dto.Id,
            CreationDateTime = DateTime.Parse(dto.DateOfCreation),
            EndDate = DateTime.Parse(dto.TimeInterval.FinishDate),
            OwnerEmail = dto.PetOwnerEmail,
            PostalCode = dto.PostalCode,
            ServiceDescription = dto.Description,
            StartDate = DateTime.Parse(dto.TimeInterval.StartDate)
        };
        return announcement;
    }

    public Task<IEnumerable<AnnouncementCreationDto>> GetAsync(SearchAnnouncementDto dto)
    {
        var request = new SearchField
        {
            StartTime = dto.StartTime,
            EndTime = dto.EndTime,
            Description = dto.Description,
            PostalCode = dto.PostalCode
        };
        Announcements list = announcementServiceClient.FindAnnouncements(request);
        throw new NotImplementedException();
    }

    private void PrintAnnouncement(Announcement dto)
    {
        Console.WriteLine($"Email: {dto.PetOwnerEmail} \ndateOfCreation: {dto.DateOfCreation}\nPostalCode: {dto.PostalCode}");
    }

    private IEnumerable<AnnouncementCreationDto> ConvertAnnouncementList(Announcements announcements)
    {
        throw new NotImplementedException();
    }
}
    

    