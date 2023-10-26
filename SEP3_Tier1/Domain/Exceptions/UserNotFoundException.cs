namespace Domain.Exceptions;

public class UserNotFoundException: Exception
{
    private string email;
    public UserNotFoundException(string email)
    {
        this.email = email;
    }
    
    private UserNotFoundException(){}

    public override string Message => $"User with email {email} doesn't exist";
    
}