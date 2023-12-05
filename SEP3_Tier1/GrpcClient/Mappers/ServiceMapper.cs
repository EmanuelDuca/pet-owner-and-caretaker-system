using Application.DaoInterface;
using Domain.Models;
using Domain.Models.Enums;

namespace GrpcClient.Mappers;

public class ServiceMapper
{
    private readonly IUserDao userService;
    private readonly IAnnouncementDao announcementService;
    public AnnouncementMapper AnnouncementMapper { get; private set; }
    
    public ServiceMapper(IUserDao userService, IAnnouncementDao announcementService)
    {
        this.userService = userService;
        this.announcementService = announcementService;
        AnnouncementMapper = new AnnouncementMapper(this.userService);
    }
    
    public async Task<Service> MapToEntity(ServiceProto proto)
    {
        var service = new Service()
        {
            Announcement = await AnnouncementMapper.MapToEntity(proto.Announcement),
            PetOwner = (PetOwner) (await userService.GetByEmailAsync(proto.PetOwnerEmail))!,
            Id = proto.Id,
            Status = (ServiceEnum) (int) proto.Status,
            CareTaker = (CareTaker) (await userService.GetByEmailAsync(proto.CaretakerEmail))!
        };
        return service;
    }
    
    public async Task<ServiceRequest> MapToEntity(ServiceRequestProto proto)
    {
        var serviceRequest = new ServiceRequest()
        {
            Announcement = await announcementService.GetByIdAsync(proto.AnnouncementId),
            Id = proto.Id,
            Initiator = (CareTaker) (await userService.GetByEmailAsync(proto.InitiatorEmail))!,
            Recipient = (PetOwner) (await userService.GetByEmailAsync(proto.RecipientEmail))!,
            RequestEnum = (RequestEnum) (int) proto.Status
        };
        return serviceRequest;
    }
}