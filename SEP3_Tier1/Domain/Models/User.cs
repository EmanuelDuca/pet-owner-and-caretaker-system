using System.Text.Json.Serialization;

namespace Domain.Models;

public class User
{
    public string? Name { get; set; }
    public string UserName { get; set; }
    public int? Age { get; set; }
    public string Email { get; set; }
    public int? PhoneNumber { get; set; }
    public string Password { get; set; }
    public string Type { get; set; }
}