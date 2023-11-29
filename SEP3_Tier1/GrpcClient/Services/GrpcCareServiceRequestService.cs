using Application.DaoInterface;
using Domain.DTOs;
using Domain.Models;
using Grpc.Core;
using GrpcClient.Mappers;

namespace GrpcClient.Services;

public class GrpcCareServiceRequestService : ICareServiceRequestDao
{
    private readonly CareServiceRequest.CareServiceRequestClient careRequestClient;

    public async Task OfferAsync(string initiatorEmail, int announcementId, string recipientEmail)
    {
        try
        {
            await careRequestClient
                .OfferCareAsync(new StartCareServiceRequest
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