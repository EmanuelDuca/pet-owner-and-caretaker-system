namespace Domain.DTOs;

public class UserCreationDto
{
    public string UserName { get; }
    public string Email { get; }
    public string Password { get; }
    public string Type { get; }

    public UserCreationDto(string email, string userName, string password, string type)
    {
        UserName = userName;
        Email = email;
        Password = password;
        Type = type;
    }
}