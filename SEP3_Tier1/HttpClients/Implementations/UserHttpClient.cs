using System.Net.Http.Json;
using System.Security.Claims;
using Domain;
using Domain.DTOs;
using Domain.Models;
using HttpClients.ClientInterfaces;

namespace HttpClients.Implementations;

public class UserHttpClient : IUserService
{
    private readonly HttpClient client;
    private readonly string START_URI = "users";


    public UserHttpClient(HttpClient client)
    {
        this.client = client;
    }
    public async Task<IEnumerable<User>> GetUsers(SearchUsersDto dto)
    {
        HttpResponseMessage response = await client.GetAsync($"{START_URI}" + await HttpClientHelper.ConstructQuery(dto));
        string responseContent = await HttpClientHelper.HandleResponse(response);
        return await HttpClientHelper.GenerateObjectFromJson<IEnumerable<User>>(responseContent);
    }

    public async Task<IEnumerable<Pet>> GetPetsOfUser(string userEmail)
    {
        HttpResponseMessage response = await client.GetAsync($"{START_URI}/pets/{userEmail}");
        string responseContent = await HttpClientHelper.HandleResponse(response);
        return await HttpClientHelper.GenerateObjectFromJson<IEnumerable<Pet>>(responseContent);
    }

    public async Task EditProfile(UserEditDto dto)
    {
        HttpResponseMessage responseMessage = await client.PostAsJsonAsync($"{START_URI}/edit", dto);
        await HttpClientHelper.HandleResponse(responseMessage);
    }

    public async Task DeleteProfile(string email)
    {
        HttpResponseMessage response = await client.DeleteAsync($"{START_URI}/{email}");
        await HttpClientHelper.HandleResponse(response);
    }
}