using Application.DaoInterface;
using Domain.DTOs;
using Domain.Models;
using Domain.Models.Enums;
using Grpc.Core;
using GrpcClient.Mappers;
using Microsoft.VisualBasic.CompilerServices;

namespace GrpcClient.Services;

public class GrpcCareServiceRequestService : ICareServiceRequestDao
{
    private readonly ServiceService.ServiceServiceClient careRequestClient;
    private readonly IUserDao userService;
    private readonly IAnnouncementDao announcementService;
    private ServiceMapper mapper;

    public GrpcCareServiceRequestService(ServiceService.ServiceServiceClient careRequestClient, IUserDao userDao, IAnnouncementDao announcementDao)
    {
        this.careRequestClient = careRequestClient;
        this.userService = userDao;
        this.announcementService = announcementDao;
        mapper = new ServiceMapper(userService, announcementService);
    }

    public async Task OfferAsync(CreateOfferCareDto dto)
    {
        try
        {
            await careRequestClient
                .RequestStartServiceAsync(new ServiceRequestProto
                {
                    AnnouncementId = dto.AnnouncementId,
                    InitiatorEmail = dto.InitiatorId,
                    RecipientEmail = dto.RecipientId,
                    // TODO Status = dto.RequestEnum
                });
        }
        catch (RpcException e)
        {
            throw new Exception(e.Status.Detail);
        }
    }
    
    public async Task AcceptAsync(int requestId)
    {
        try
        {
            await careRequestClient
                .AcceptStartServiceAsync(new FindRequestServiceProto()
                {
                    RequestId = requestId
                });
        }
        catch (RpcException e)
        {
            throw new Exception(e.Message);
        }
    }
    
    public async Task DenyAsync(int requestId)
    {
        try
        {
            await careRequestClient
                .DenyStartServiceAsync(new FindRequestServiceProto()
                {
                    RequestId = requestId
                });
        }
        catch (RpcException e)
        {
            throw new Exception(e.Message);
        }
    }
    
    public async Task EndAsync(int serviceId)
    {
        try
        {
            await careRequestClient
                .EndServiceAsync(new FindServiceProto()
                {
                    ServiceId = serviceId
                });
        }
        catch (RpcException e)
        {
            throw new Exception(e.Message);
        }
    }
    
    public async Task<IEnumerable<ServiceRequest>> GetRequestsAsync(int announcementId)
    {
        try
        {
            await careRequestClient
                .SearchRequestServicesAsync(new FindAnnouncementProto()
                {
                    //TODO
                });
            return null;
        }
        catch (RpcException e)
        {
            throw new Exception(e.Message);
        }
    }
    
    public async Task<Service> GetServiceAsync(int serviceId)
    {
        try
        {
            await careRequestClient
                .FindServiceAsync(new FindServiceProto()
                {
                    ServiceId = serviceId
                });
            return null; //TODO
        }
        catch (RpcException e)
        {
            throw new Exception(e.Message);
        }
    }
    
    public async Task<IEnumerable<Service>> GetServicesAsync(SearchServicesDto dto)
    {
        try
        {
            var serviceProto = new SearchServiceProto()
            {
                CaretakerEmail = dto.caretakerEmail,
                PetOwnerEmail = dto.petOwnerEmail
            };

            if (dto.status != null)
                serviceProto.Status = (ServiceStatus)(int)dto.status;
            
            ServicesProto services = await careRequestClient
                .SearchServicesAsync(serviceProto);
            return await mapper.MapToEntityList(services);
        }
        catch (RpcException e)
        {
            throw new Exception(e.Status.Detail);
        }
    }
    
    public async Task AddFeedbackAsync(string feedback, int rating,  string email, int serviceId)
    {
        try
        {
            await careRequestClient
                .AddFeedbackAsync(new FeedbackProto()
                {
                    Feedback = feedback,
                    Rating = rating,
                    ServiceId = serviceId,
                    CaretakerEmail = email
                });
        }
        catch (RpcException e)
        {
            throw new Exception(e.Message);
        }
    }
    
    public async Task DeleteFeedbackAsync(int serviceId, string email)
    {
        try
        {
            await careRequestClient
                .DeleteFeedbackAsync(new FindFeedbackProto()
                {
                    ServiceId = serviceId,
                    CaretakerEmail = email
                });
        }
        catch (RpcException e)
        {
            throw new Exception(e.Message);
        }
    }
    
    //Should be nullable as well,
    public async Task GetFeedbacks(string email)
    {
        try
        {
            await careRequestClient
                .SearchFeedbacksAsync(new FindUserProto()
                {
                    Email = email
                });
        }
        catch (RpcException e)
        {
            throw new Exception(e.Message);
        }
    }


}