using Application.DaoInterface;
using Domain.DTOs;
using Domain.Models;
using Grpc.Core;
using GrpcClient.Mappers;
using Microsoft.VisualBasic.CompilerServices;

namespace GrpcClient.Services;

public class GrpcCareServiceRequestService : ICareServiceRequestDao
{
    private readonly ServiceService.ServiceServiceClient careRequestClient;

    public async Task OfferAsync(string initiatorEmail, int announcementId, string recipientEmail)
    {
        try
        {
            await careRequestClient
                .RequestStartServiceAsync(new ServiceRequestProto
                {
                    AnnouncementId = announcementId,
                    InitiatorEmail = initiatorEmail,
                    RecipientEmail = recipientEmail
                });
        }
        catch (RpcException e)
        {
            throw new Exception(e.Message);
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
    
    //TODO ask Dan: if int id is given as null, will all the requests be returned?
    //And what is FindService?
    public async Task GetRequestsAsync(int/*?*/ requestId)
    {
        try
        {
            await careRequestClient
                .SearchRequestServicesAsync(new FindAnnouncementProto()
                {
                    Id = requestId
                });
        }
        catch (RpcException e)
        {
            throw new Exception(e.Message);
        }
    }
    
    public async Task GetServicesAsync(int/*?*/ serviceId)
    {
        try
        {
            await careRequestClient
                .SearchServicesAsync(new SearchServiceProto()
                {
                     // TODO
                });
        }
        catch (RpcException e)
        {
            throw new Exception(e.Message);
        }
    }
    
    public async Task AddFeedbackAsync(string feedback, int rating,  string email)
    {
        try
        {
            await careRequestClient
                .AddFeedbackAsync(new FeedbackProto()
                {
                    Feedback = feedback,
                    Rating = rating,
                    Service = new ServiceProto()
                    {
                        //TODO Why not simply serviceId?
                    },
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