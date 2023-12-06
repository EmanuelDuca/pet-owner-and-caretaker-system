using System.Net.Http.Json;
using System.Text;
using System.Text.Json;
using Domain;
using Domain.DTOs;
using Domain.Models;
using HttpClients.ClientInterfaces;
using Newtonsoft.Json;

namespace HttpClients.Implementations;

public class AnnouncementHttpClient : IAnnouncementService
{
    private readonly HttpClient client;
    private readonly string START_URI = "/announcements";

    public AnnouncementHttpClient(HttpClient client)
    {
        this.client = client;
    }
    
    
    public async Task<Announcement> CreateAsync(CreateAnnouncementDto dto)
    {
        HttpResponseMessage response = await client.PostAsJsonAsync(START_URI, dto);
        string content = await HttpClientHelper.HandleResponse(response);
        return await HttpClientHelper.GenerateObjectFromJson<Announcement>(content);
    }

    public async Task<IEnumerable<Announcement>> GetAsync(SearchAnnouncementDto? dto)
    {
        HttpResponseMessage response = await client.PostAsJsonAsync(START_URI + "/filter", dto);
        string responseContent = await HttpClientHelper.HandleResponse(response);
        return await HttpClientHelper.GenerateObjectFromJson<IEnumerable<Announcement>>(responseContent);
    }

    public async Task<Announcement> GetByIdAsync(int id)
    {
        HttpResponseMessage response = await client.GetAsync($"{START_URI}/{id}");
        string content = await HttpClientHelper.HandleResponse(response);   
        return await HttpClientHelper.GenerateObjectFromJson<Announcement>(content);
    }

    public async Task UpdateAsync(UpdateAnnouncementDto dto)
    {
        HttpResponseMessage response = await client.PatchAsJsonAsync(START_URI, dto);
        await HttpClientHelper.HandleResponse(response);
    }

    public async Task DeleteAsync(int id)
    {
        HttpResponseMessage response = await client.DeleteAsync($"{START_URI}/{id}");
        await HttpClientHelper.HandleResponse(response);    
    }
    
    public async Task<IEnumerable<Service>> GetServicesAsync(SearchServicesDto dto)
    {
        HttpResponseMessage response = await client.PostAsJsonAsync("/communication/services", dto);
        string responseContent = await HttpClientHelper.HandleResponse(response);
        return await HttpClientHelper.GenerateObjectFromJson<IEnumerable<Service>>(responseContent);
    }

    public async Task CreateRequestAsync(CreateOfferCareDto dto)
    {
        HttpResponseMessage response = await client.PostAsJsonAsync("/communication/offer", dto);
        await HttpClientHelper.HandleResponse(response);
    }
    
    public async Task<Service> GetServiceAsync(int serviceId)
    {
        HttpResponseMessage response = await client.GetAsync("/communication/service/" + serviceId);
        Console.WriteLine("TEST");
        string responseContent = await HttpClientHelper.HandleResponse(response);
        return await HttpClientHelper.GenerateObjectFromJson<Service>(responseContent);
    }
}