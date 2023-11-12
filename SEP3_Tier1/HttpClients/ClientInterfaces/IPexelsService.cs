using HttpClients.Implementations;
using PexelsDotNetSDK.Api;

namespace HttpClients.ClientInterfaces;

public interface IPexelsService
{
    Task<string> SearchPetImage(string query = "Pet", int pageSize = 25);
    Task<List<string>> SearchPetImageSet(int imageNumber);
    Task<List<string>> CustomSearch(string query, string orientation, int pageSize);
}