using System.Text.Json.Serialization;

namespace Domain.Models;

public class User
{
    public string? Name { get; set; }
    public string Username { get; init; }
    public int? Age { get; set; }
    public string Email { get; init; }
    public string? PhoneNumber { get; set; }
    public string Password { get; init; }
}