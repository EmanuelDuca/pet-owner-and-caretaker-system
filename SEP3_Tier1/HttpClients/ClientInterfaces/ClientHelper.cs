using System.Reflection;
using System.Text.Json;
using Domain.DTOs;

namespace HttpClients.ClientInterfaces;

public abstract class ClientHelper
{
    public static async Task<string> HandleResponse(HttpResponseMessage response)
    {
        string responseMessage = await response.Content.ReadAsStringAsync();
        if (!response.IsSuccessStatusCode)
        {
            Console.WriteLine(responseMessage); // Todo change to log
            throw new Exception(responseMessage);
        }

        return responseMessage;
    }
    
    public static Task<T> GenerateObjectFromJson<T>(string content)
    {
        return Task.FromResult(JsonSerializer.Deserialize<T>(content,
            new JsonSerializerOptions()
            {
                PropertyNameCaseInsensitive = true
            })!);
    }

    public static Task<string> ConstructQuery(SearchDto searchDto)
    {
        string query = "";

        var fields = searchDto.GetType().GetProperties();
        
        for (int i = 0; i < fields.Length; i++)
        {
            Object? value = fields[i].GetValue(searchDto);
            string pascalCaseName = fields[i].Name;


            if ((fields[i] == typeof(string) && !string.IsNullOrEmpty((string?)value))
                || (fields[i] != typeof(string) && value != null))
            {
                query += string.IsNullOrEmpty(query) ? "?" : "&";
                string fieldName = JsonNamingPolicy.CamelCase.ConvertName(pascalCaseName);
                query += $"{fieldName}={value}";
            }
        }

        return Task.FromResult(query);
    }
}