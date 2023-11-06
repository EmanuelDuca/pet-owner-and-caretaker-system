using System.Net.Http.Json;
using System.Text.Json;
using Domain;
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
        string content = await HttpClientHelper.HandleResponse(response);
        return await HttpClientHelper.GenerateObjectFromJson<Announcement>(content);
    }

    public async Task<IEnumerable<Announcement>> GetAsync(SearchAnnouncementDto dto)
    {
        HttpResponseMessage response = await client.GetAsync(START_URI);
        string content = await HttpClientHelper.HandleResponse(response);
        IEnumerable<Announcement> announcements = JsonSerializer.Deserialize<IEnumerable<Announcement>>(content, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
        return announcements;
    }
}