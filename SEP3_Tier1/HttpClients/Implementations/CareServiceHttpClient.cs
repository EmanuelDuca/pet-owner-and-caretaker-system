using System.Net.Http.Json;
using Domain;
using Domain.DTOs;
using Domain.Models;
using HttpClients.ClientInterfaces;

namespace HttpClients.Implementations;

public class CareServiceHttpClient : ICareServiceService
{
    private readonly HttpClient client;
    private readonly string START_URI = "/communication";

    public CareServiceHttpClient(HttpClient client)
    {
        this.client = client;
    }

    public async Task OfferServiceAsync(CreateOfferCareDto offerDto)
    {
        HttpResponseMessage responseMessage = await client.PostAsJsonAsync($"{START_URI}/offer", offerDto);
        await HttpClientHelper.HandleResponse(responseMessage);
    }

    public async Task AcceptServiceAsync(int requestId)
    {
        HttpResponseMessage responseMessage = await client.PostAsJsonAsync($"{START_URI}/accept", requestId);
        await HttpClientHelper.HandleResponse(responseMessage);
    }

    public async Task EndServiceAsync(int serviceId)
    {
        HttpResponseMessage responseMessage = await client.PostAsJsonAsync($"{START_URI}/end", serviceId);
        await HttpClientHelper.HandleResponse(responseMessage);
    }

    public async Task DenyServiceAsync(int requestId)
    {
        HttpResponseMessage responseMessage = await client.PostAsJsonAsync($"{START_URI}/deny", requestId);
        await HttpClientHelper.HandleResponse(responseMessage);
    }

    public async Task<IEnumerable<ServiceRequest>> GetServiceOffersAsync(int announcementId)
    {
        HttpResponseMessage responseMessage = await client.GetAsync($"{START_URI}/requests/{announcementId}");
        string json = await HttpClientHelper.HandleResponse(responseMessage);
        Console.WriteLine(json);
        return await HttpClientHelper.GenerateObjectFromJson<IEnumerable<ServiceRequest>>(json);
    }

    public async Task<Service> GetServiceAsync(int serviceId)
    {
        HttpResponseMessage responseMessage = await client.GetAsync($"{START_URI}/service/{serviceId}");
        string json = await HttpClientHelper.HandleResponse(responseMessage);
        return await HttpClientHelper.GenerateObjectFromJson<Service>(json);
    }

    public async Task<IEnumerable<Service>> GetServicesAsync(SearchServicesDto dto)
    {
        HttpResponseMessage responseMessage = await client.PostAsJsonAsync($"{START_URI}/services", dto);
        string json = await HttpClientHelper.HandleResponse(responseMessage);
        return await HttpClientHelper.GenerateObjectFromJson<IEnumerable<Service>>(json);
    }

    public async Task GiveFeedbackAsync(Feedback feedback)
    {
        HttpResponseMessage responseMessage = await client.PostAsJsonAsync($"{START_URI}/feedback", feedback);
        await HttpClientHelper.HandleResponse(responseMessage);
    }

    public async Task DeleteFeedbackAsync(int serviceId, string email)
    {
        HttpResponseMessage responseMessage = await client.DeleteAsync($"{START_URI}/feedback/{serviceId}&{email}");
        await HttpClientHelper.HandleResponse(responseMessage);
    }

    public async Task<IEnumerable<Feedback>> GetFeedbacks(string email)
    {
        HttpResponseMessage responseMessage = await client.GetAsync($"{START_URI}/feedback/{email}");
        string json = await HttpClientHelper.HandleResponse(responseMessage);
        return await HttpClientHelper.GenerateObjectFromJson<IEnumerable<Feedback>>(json);
    }

    public async Task<double> GetCaretakerFeedback(string email)
    {
        var feedbacks = await GetFeedbacks(email) as Feedback[] ?? (await GetFeedbacks(email)).ToArray();
        double average = 0;
        foreach (var f in feedbacks)
        {
            average += f.Rating != 0? f.Rating : 1;
        }

        return average / (!feedbacks.Any()? 1 : feedbacks.Length);
    }
}