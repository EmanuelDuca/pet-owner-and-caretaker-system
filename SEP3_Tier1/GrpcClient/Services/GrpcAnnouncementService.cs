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

    public Task<Announcement> CreateAsync(Announcement ann)
    {
        try
        {
            var request = new AnnouncementProto
            {
                PetOwnerEmail = ann.PetOwner.Email,
                Description = ann.ServiceDescription,
                TimeStart = ann.StartDate.ToShortDateString(),
                TimeFinish = ann.EndDate.ToShortDateString(),
                Pet = new PetProto
                {
                    PetName = ann.Pet.PetName,
                    PetType = ann.Pet.PetType.ToString(),
                    Weight = ann.Pet.Weight,
                    IsVaccinated = ann.Pet.IsVaccinated,
                    Description = ann.Pet.Description,
                },
                PostalCode = ann.PostalCode,
                DateOfCreation = ann.CreationDateTime.ToShortDateString()
            };
        
            AnnouncementProto grpcAnnouncementToCreate = announcementServiceClient.CreateAnnouncement(request);

            return ConvertAnnouncementFromProto(grpcAnnouncementToCreate);
        }
        catch (RpcException e)
        {
            throw new Exception(e.Message);
        }
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
        try
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
        catch (RpcException e)
        {
            throw new Exception(e.Message);
        }
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
        try
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
            
            return Task.FromCanceled(CancellationToken.None);
        }
        catch (RpcException e)
        {
            throw new Exception(e.Message);
        }
        
    }

    public Task DeleteAsync(int id)
    {
        try
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
        catch (RpcException e)
        {
            throw new Exception(e.Message);
        }
    }
}
    

    