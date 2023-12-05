using HttpClients.ClientInterfaces;
using PexelsDotNetSDK.Api;
using PexelsDotNetSDK.Models;

namespace HttpClients.Implementations;

public class PexelsService : IPexelsService
{
    private readonly PexelsClient client;

    public PexelsService(PexelsClient client)
    {
        this.client = client;
    }

    public async Task<string> SearchPetImage(string query = "Pet", int pageSize = 25)
    {
        var photo = await client.SearchPhotosAsync(query, "landscape", pageSize: pageSize);
        return photo.photos[new Random().Next(photo.photos.Count - 1)].source.original;
    }
    
    public async Task<List<string>> SearchPetImageSet(int imageNumber)
    {
        var photo = await client.SearchPhotosAsync("Pet", "landscape", pageSize: imageNumber);
        return photo.photos.Select(p => p.source.original).ToList();
    }
    
    public async Task<List<string>> CustomSearch(string query, string orientation = "landscape", int pageSize = 1)
    {
        var photo = await client.SearchPhotosAsync(query, orientation, pageSize: pageSize);
        return photo.photos.Select(p => p.source.original).ToList();
    }
}