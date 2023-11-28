namespace Domain.Models;

public class CareTaker : User
{
    public CareTaker(){}
    public CareTaker(User user)
    {
        Age = user.Age;
        Name = user.Name;
        Email = user.Email;
        Password = user.Password;
        PhoneNumber = user.PhoneNumber;
    }
}