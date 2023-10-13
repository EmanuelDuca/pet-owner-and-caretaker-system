namespace Domain.DTOs;

public class UserCreationDto
{
    public string UserName { get; set; }
    public string Email { get; set; }
    public string Password { get; set; }
    public string Type { get; set; }

    public UserCreationDto(string name, string email,string password , string type)
    {
        UserName = name;
        Email = email;
        Password = password;
        Type = type;
    }
}