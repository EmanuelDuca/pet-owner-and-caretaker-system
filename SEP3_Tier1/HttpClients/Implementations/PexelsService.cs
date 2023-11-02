using HttpClients.ClientInterfaces;
using PexelsDotNetSDK.Api;

namespace HttpClients.Implementations;

public class PexelsService : IPexelsService
{
    private readonly PexelsClient client;

    public PexelsService(PexelsClient client)
    {
        this.client = client;
    }

    public async Task<string> SearchPetImage()
    {
        var photo = await client.SearchPhotosAsync("Pet", "landscape", pageSize: 25);
        return photo.photos[new Random().Next(25)].source.original;
    }
}