using Domain.Models;
using HttpClients.ClientInterfaces;

namespace HttpClients.Implementations;

public class UserHttpClient : IUserService
{
    private readonly string SRART_URI = "/users";
    private readonly HttpClient client;

    public UserHttpClient(HttpClient client)
    {
        this.client = client;
    }
    

    public async Task<IEnumerable<User>> GetAsync()
    {
        HttpResponseMessage response = await client.GetAsync(SRART_URI);
        string content = await ClientHelper.HandleResponse(response);
        return await ClientHelper.GenerateObjectFromJson<IEnumerable<User>>(content);
    }
}