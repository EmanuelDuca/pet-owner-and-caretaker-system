namespace Domain.DTOs;

public class UserEditDto
{
    public string? Name { get; }
    public string? UserName { get; }
    public int? Age { get; }
    public string Email { get; }
    public string? PhoneNumber { get; }
    public string? Password { get; }

    public UserEditDto(string email, string userName, string password)
    {
        UserName = userName;
        Email = email;
        Password = password;
    }
}