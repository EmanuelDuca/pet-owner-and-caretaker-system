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
    
    public async Task<Feedback> MapToEntity(FeedbackProto proto)
    {
        var feedback = new Feedback()
        {
            feedback = proto.Feedback,
            rating = proto.Rating,
            caretakerEmail = proto.CaretakerEmail,
            serviceId = proto.ServiceId
        };
        return feedback;
    }
    
    public async Task<IEnumerable<Service>> MapToEntityList(ServicesProto proto)
    {
        return await Task.WhenAll(proto.Services
            .Select(async service => await MapToEntity(service)));
    }
    public async Task<IEnumerable<ServiceRequest>> MapToEntityList(RequestServicesProto proto)
    {
        return await Task.WhenAll(proto.RequestServices
            .Select(async requestService => await MapToEntity(requestService)));
    }
    public async Task<IEnumerable<Feedback>> MapToEntityList(FeedbacksProto proto)
    {
        return await Task.WhenAll(proto.Feedback
            .Select(async requestService => await MapToEntity(requestService)));
    }
}