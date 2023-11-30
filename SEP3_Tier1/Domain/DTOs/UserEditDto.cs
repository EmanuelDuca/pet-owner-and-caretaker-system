namespace Domain.DTOs;

public class UserEditDto
{
    public string? Name { get; set; }
    public string? UserName { get;set; }
    public int? Age { get; set;}
    public string Email { get; }
    public string? PhoneNumber { get; set;}
    public string? Password { get; set; }

    public UserEditDto(string email)
    {
        Email = email;
    }
}