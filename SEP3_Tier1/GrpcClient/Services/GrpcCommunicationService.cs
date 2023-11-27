using Application.DaoInterface;
using Domain.DTOs;
using Domain.Models;
using Grpc.Core;
using GrpcClient.Mappers;

namespace GrpcClient.Services;

public class GrpcCommunicationService : ICommunicationDao
{
    private readonly CommunicationService.CommunicationServiceClient communicationServiceClient;

    public async Task OfferAsync(CareTaker caretaker)
    {
        try
        {
            ResponseStatus status = await communicationServiceClient.OfferCareAsync(UserMapper.UserProtoGenerator(caretaker));
            if (int.Parse(status.ResponseStatus_) == 404)
            {
                throw new Exception($"Your services has not been offered -- response status {status} from Java");
            }
            Console.WriteLine($"Java returned {status}");
        }
        catch (RpcException e)
        {
            throw new Exception(e.Message);
        }
    }
}