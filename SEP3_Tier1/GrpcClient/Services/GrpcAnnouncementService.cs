using System.Globalization;
using System.Runtime.CompilerServices;
using Application.DaoInterface;
using Domain;
using Domain.DTOs;
using Grpc.Net.Client;
using Domain.Models;
using GrpcClient.Mappers;
using HttpClients.ClientInterfaces;

namespace GrpcClient.Services;
using Domain.DTOs;
using Grpc.Core;
using Grpc.Net.Client;
using GrpcClient;

public class GrpcAnnouncementService : IAnnouncementDao
{
    private readonly AnnouncementService.AnnouncementServiceClient announcementServiceClient;
    private readonly IUserDao userService;
    private AnnouncementMapper mapper;

    public GrpcAnnouncementService(AnnouncementService.AnnouncementServiceClient announcementServiceClient, IUserDao userService)
    {
        this.announcementServiceClient = announcementServiceClient;
        this.userService = userService;
        mapper = new AnnouncementMapper(userService);
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
                    OwnerEmail = ann.PetOwner.Email
                },
                PostalCode = ann.PostalCode,
                DateOfCreation = ann.CreationDateTime.ToShortDateString()
            };
        
            AnnouncementProto grpcAnnouncementToCreate = announcementServiceClient.CreateAnnouncement(request);

            return mapper.MapToEntity(grpcAnnouncementToCreate);
        }
        catch (RpcException e)
        {
            throw new Exception(e.Message);
        }
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
            return await mapper.MapToEntityList(announcements);
        }
        catch (RpcException e)
        {
            throw new Exception(e.Message);
        }
    }

    

    public async Task UpdateAsync(AnnouncementUpdateDto dto)
    {
        try
        {
            var request = new AnnouncementProto
            {
                Id = dto.Id,
                TimeStart = dto.StartDate?.ToShortDateString(),
                TimeFinish = dto.EndDate?.ToShortDateString(),
                PostalCode = dto.PostalCode,
                Description = dto.ServiceDescription,
                Pet = await mapper.PetMapper.MapToProto(dto.Pet!)
            };
            AnnouncementProto updated = announcementServiceClient.UpdateAnnouncement(request);
            if (updated.Id != request.Id)
            {
                throw new Exception("Announcement was not updated.");
            }
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
    

    