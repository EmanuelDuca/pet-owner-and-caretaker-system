using System.Net.Http.Json;
using Domain;
using Domain.DTOs;
using Domain.Models;
using HttpClients.ClientInterfaces;

namespace HttpClients.Implementations;

public class UserHttpClient : IUserService
{
    private readonly HttpClient client;
    private readonly string START_URI = "/users";

    public UserHttpClient(HttpClient client)
    {
        this.client = client;
    }

    public async Task<IEnumerable<User>> GetAsync(SearchUsersDto dto)
    {
        HttpResponseMessage response = await client.GetAsync(START_URI + await HttpClientHelper.ConstructQuery(dto));
        string responseContent = await HttpClientHelper.HandleResponse(response);
        return await HttpClientHelper.GenerateObjectFromJson<IEnumerable<User>>(responseContent);
    }
}