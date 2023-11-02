using HttpClients.Implementations;
using PexelsDotNetSDK.Api;

namespace HttpClients.ClientInterfaces;

public interface IPexelsService
{
    Task<string> SearchPetImage();
}