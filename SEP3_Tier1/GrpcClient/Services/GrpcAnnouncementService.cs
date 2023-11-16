using System.Globalization;
using System.Runtime.CompilerServices;
using Application.DaoInterface;
using Domain;
using Domain.DTOs;
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

    private async Task<Pet> ConvertPetFromProto(PetProto proto)
    {
        return new Pet()
        {
            Id = proto.Id,
            Description = proto.Description,
            IsVaccinated = proto.IsVaccinated,
            Weight = proto.Weight,
            PetName = proto.PetName,
            PetType = Enum.Parse<PetType.Type>(proto.PetType)
        };
    }


    private async Task<Announcement> ConvertAnnouncementFromProto(AnnouncementProto proto)
    {
        Console.WriteLine($"Date of Creation it is[{proto.DateOfCreation}]");

        var announcement = new Announcement
        {
            Id = proto.Id,
            CreationDateTime = DateTime.Parse(proto.DateOfCreation),
            StartDate = DateTime.Parse(proto.TimeStart),
            EndDate = DateTime.Parse(proto.TimeFinish),
            PetOwner = (PetOwner) (await userService.GetByEmailAsync(proto.PetOwnerEmail))!,
            PostalCode = proto.PostalCode,
            ServiceDescription = proto.Description,
            Pet = await ConvertPetFromProto(proto.Pet)
        };
        return announcement;
    }

    public async Task<IEnumerable<Announcement>> GetAsync(SearchAnnouncementDto dto)
    {
        var request = new SearchAnnouncementProto
        {
            // TimeStart = dto.StartTime,
            // TimeFinish = dto.EndTime,
            // PostalCode = dto.PostalCode
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
        // Announcement? existing = await GetByIdAsync(dto.Id);
        // todo: need to be implemented!
        
        var request = new AnnouncementProto
        {
            Id = dto.Id,
            TimeStart = dto.StartDate?.ToShortDateString(),
            TimeFinish = dto.EndDate?.ToShortDateString(),
            PostalCode = dto.PostalCode,
            Description = dto.ServiceDescription,
            Pet = new PetProto
            {
                PetName = dto.Pet.PetName,
                PetType = dto.Pet.PetType.ToString(),
                Weight = dto.Pet.Weight,
                IsVaccinated = dto.Pet.IsVaccinated,
                Description = dto.Pet.Description,
                Id = dto.Pet.Id
            }
        };
        AnnouncementProto updated = announcementServiceClient.UpdateAnnouncement(request);
        if (updated.Id == request.Id)
        {
            return Task.CompletedTask;
        }
        return null;
    }

    public Task DeleteAsync(int id)
    {
        FindAnnouncementProto request = new FindAnnouncementProto
        {
            Id = id
        };

        ResponseStatus status = announcementServiceClient.DeleteAnnouncement(request);
        if (int.Parse(status.ResponseStatus_) == 404)
        {
            throw new Exception($"Announcement was not deleted -- response status {status} from Java");
        }
        return Task.CompletedTask;
    }

    public Task<Announcement> CreateAsync(Announcement announcement)
    {
        throw new NotImplementedException();
    }
}
    

    