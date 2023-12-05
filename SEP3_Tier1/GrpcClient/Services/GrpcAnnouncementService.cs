using Application.DaoInterface;
using Domain.Models;
using Google.Protobuf.Collections;
using Google.Protobuf.WellKnownTypes;
using GrpcClient.Mappers;
using GrpcClient.Utils;
using Microsoft.Extensions.Primitives;

namespace GrpcClient.Services;
using Domain.DTOs;
using Grpc.Core;

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

    public async Task<Announcement> CreateAsync(Announcement ann)
    {
        try
        {
            var request = new AnnouncementProto
            {
                PetOwnerEmail = ann.PetOwner.Email,
                Description = ann.ServiceDescription,
                TimeStart = TimestampConverter.FromDateTime(ann.StartDate),
                TimeFinish = TimestampConverter.FromDateTime(ann.EndDate),
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
                DateOfCreation = TimestampConverter.FromDateTime(ann.CreationDateTime)
            };
        
            AnnouncementProto grpcAnnouncementToCreate = await announcementServiceClient.CreateAnnouncementAsync(request);

            return await mapper.MapToEntity(grpcAnnouncementToCreate);
        }
        catch (RpcException e)
        {
            throw new Exception(e.Status.Detail);
        }
    }

    public async Task<Announcement> GetByIdAsync(int id)
    {
        try
        {
            var announcementProto = await announcementServiceClient.FindAnnouncementAsync(new FindAnnouncementProto()
            {
                Id = id
            });

            return await mapper.MapToEntity(announcementProto);
        }
        catch (RpcException e)
        {
            throw new Exception(e.Status.Detail);
        }
    }


    public async Task<IEnumerable<Announcement>> GetAsync(SearchAnnouncementDto dto)
    {
        try
        {
            var request = new SearchAnnouncementProto()
            {
                PetOwnerEmail = dto.UserEmail,
                PostalCode = dto.PostalCode,
                TimeStart = dto.EndTime == null? null : TimestampConverter.FromDateTime(dto.StartTime!.Value),
                TimeFinish = dto.EndTime == null? null : TimestampConverter.FromDateTime(dto.EndTime!.Value),
                PetIsVaccinated = dto.IsVaccinated,
                PetWeight = dto.LessThanPetWeight
            };

            request.PetTypes.AddRange(dto.PetTypes == null ? new RepeatedField<string>()
                : new RepeatedField<string>() { dto.PetTypes!.Select(PetType.NameFromPetType) });
            
            AnnouncementsProto announcements = await announcementServiceClient.SearchAnnouncementsAsync(request);
            return await mapper.MapToEntityList(announcements);
        }
        catch (RpcException e)
        {
            throw new Exception(e.Status.Detail);
        }
    }

    

    public async Task UpdateAsync(UpdateAnnouncementDto dto)
    {
        try
        {
            var request = new AnnouncementProto
            {
                Id = dto.Id,
                TimeStart = TimestampConverter.FromDateTime(dto.StartDate!.Value),
                TimeFinish = TimestampConverter.FromDateTime(dto.EndDate!.Value),
                PostalCode = dto.PostalCode,
                Description = dto.ServiceDescription,
                Pet = dto.Pet == null? null : await mapper.PetMapper.MapToProto(dto.Pet)
            };
            AnnouncementProto updated = await announcementServiceClient.UpdateAnnouncementAsync(request);
            if (updated.Id != request.Id)
            {
                throw new Exception("Announcement was not updated.");
            }
        }
        catch (RpcException e)
        {
            throw new Exception(e.Status.Detail);
        }
        
    }

    public async Task DeleteAsync(int id)
    {
        try
        {
            FindAnnouncementProto request = new FindAnnouncementProto
            {
                Id = id
            };

            await announcementServiceClient.DeleteAnnouncementAsync(request);
        }
        catch (RpcException e)
        {
            throw new Exception(e.Status.Detail);
        }
    }
    
    

    public async Task OfferAsync(CareTaker caretaker)
    {
        try
        {
            
        }
        catch (RpcException e)
        {
            throw new Exception(e.Message);
        }
    }
}
    

    