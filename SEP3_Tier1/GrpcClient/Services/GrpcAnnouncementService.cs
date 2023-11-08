using System.Globalization;
using System.Runtime.CompilerServices;
using Application.DaoInterface;
using Domain;
using Grpc.Net.Client;
using Domain.Models;
using HttpClients.ClientInterfaces;

namespace GrpcClient.Services;
using Domain.DTOs;
using Grpc.Core;
using Grpc.Net.Client;
using GrpcClient;

public class GrpcAnnouncementService : IAnnouncementDao
{
    private AnnouncementService.AnnouncementServiceClient announcementServiceClient;
    private IUserDao userService;

    public GrpcAnnouncementService(AnnouncementService.AnnouncementServiceClient announcementServiceClient, IUserDao userService)
    {
        this.announcementServiceClient = announcementServiceClient;
        this.userService = userService;
    }

    public Task<Announcement> CreateAsync(AnnouncementCreationDto dto)
    {
        Console.WriteLine($"Print DateOfCreation Before {dto.CreationDateTime.ToShortDateString()}");
        var request = new AnnouncementProto
        {
            PetOwnerEmail = dto.OwnerEmail,
            Description = dto.ServiceDescription,
            TimeStart = dto.StartDate.ToShortDateString(),
            TimeFinish = dto.EndDate.ToShortDateString(),
            Pet = new PetProto
            {
                PetName = dto.Pet.PetName,
                PetType = dto.Pet.PetType.ToString(),
                Weight = dto.Pet.Weight,
                IsVaccinated = dto.Pet.IsVaccinated,
                Description = dto.Pet.Description,
            },
            PostalCode = dto.PostalCode,
            DateOfCreation = dto.CreationDateTime.ToShortDateString()
        };
        
        AnnouncementProto grpcAnnouncementToCreate = announcementServiceClient.CreateAnnouncement(request);
        PrintAnnouncement(grpcAnnouncementToCreate);
        Console.WriteLine($"Java returned new Announcement made by {grpcAnnouncementToCreate.PetOwnerEmail}");

        return ConvertAnnouncementFromProto(grpcAnnouncementToCreate);
    }


    private async Task<Announcement> ConvertAnnouncementFromProto(AnnouncementProto dto)
    {
        Console.WriteLine($"Date of Creation it is[{dto.DateOfCreation}]");

        var announcement = new Announcement
        {
            Id = dto.Id,
            CreationDateTime = DateTime.Parse(dto.DateOfCreation),
            StartDate = DateTime.Parse(dto.TimeStart),
            EndDate = DateTime.Parse(dto.TimeFinish),
            PetOwner = (PetOwner) (await userService.GetByEmailAsync(dto.PetOwnerEmail))!,
            PostalCode = dto.PostalCode,
            ServiceDescription = dto.Description,
        };
        return announcement;
    }

    public async Task<IEnumerable<Announcement>> GetAsync(SearchAnnouncementDto dto)
    {
        var request = new SearchAnnouncementProto
        {
            TimeStart = dto.StartTime,
            TimeFinish = dto.EndTime,
            PostalCode = dto.PostalCode
        };
        AnnouncementsProto announcements = announcementServiceClient.FindAnnouncements(request);
        return await ConvertAnnouncementListFromProto(announcements);
    }

    private void PrintAnnouncement(AnnouncementProto dto)
    {
        Console.WriteLine($"Email: {dto.PetOwnerEmail} \ndateOfCreation: {dto.DateOfCreation}\nPostalCode: {dto.PostalCode}");
    }

    private async Task<IEnumerable<Announcement>> ConvertAnnouncementListFromProto(AnnouncementsProto announcements)
    {
        return await Task.WhenAll(announcements.Announcements
            .Select(async announcement => await ConvertAnnouncementFromProto(announcement)));
    }

    public Task UpdateAsync(AnnouncementUpdateDto dto)
    {
        var request = new AnnouncementProto
        {
            Id = dto.Id,
            TimeStart = dto.StartDate.ToShortDateString(),
            TimeFinish = dto.EndDate.ToShortDateString(),
            PostalCode = dto.PostalCode
        };
        throw new NotImplementedException();
    }

    public Task DeleteAsync(int id)
    {
        throw new NotImplementedException();
    }
}
    

    