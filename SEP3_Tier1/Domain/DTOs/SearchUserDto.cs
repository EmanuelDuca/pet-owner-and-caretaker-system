namespace Domain.DTOs;

public class SearchUserDto: SearchDto
{
    public string Email { get; }

    public SearchUserDto(string email)
    {
        Email = email;
    }
}