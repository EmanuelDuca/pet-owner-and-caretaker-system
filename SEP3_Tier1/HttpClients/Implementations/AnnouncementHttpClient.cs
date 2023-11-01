using System.Net.Http.Json;
using Domain.DTOs;
using Domain.Models;
using HttpClients.ClientInterfaces;

namespace HttpClients.Implementations;

public class AnnouncementHttpClient : IAnnouncementService
{
    private readonly HttpClient client;
    private readonly string START_URI = "/announcements";

    public AnnouncementHttpClient(HttpClient client)
    {
        this.client = client;
    }
    
    
    public async Task<Announcement> CreateAsync(AnnouncementCreationDto dto)
    {
        HttpResponseMessage response = await client.PostAsJsonAsync(START_URI, dto);
        string content = await ClientHelper.HandleResponse(response);
        return await ClientHelper.GenerateObjectFromJson<Announcement>(content);
    }
}