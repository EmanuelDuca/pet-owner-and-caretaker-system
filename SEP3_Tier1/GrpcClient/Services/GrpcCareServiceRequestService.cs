using Application.DaoInterface;
using Domain.DTOs;
using Domain.Models;
using Grpc.Core;
using GrpcClient.Mappers;

namespace GrpcClient.Services;

public class GrpcCareServiceRequestService : ICareServiceRequestDao
{
    private readonly ServiceService.ServiceServiceClient careRequestClient;

    public async Task OfferAsync(string initiatorEmail, int announcementId, string recipientEmail)
    {
        try
        {
            await careRequestClient
                .RequestStartServiceAsync(new ServiceRequest
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
}