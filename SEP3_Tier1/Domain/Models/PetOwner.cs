using System.Text.Json.Serialization;

namespace Domain.Models;

public class PetOwner : User
{
    public PetOwner(){}
    public PetOwner(User user)
    {
        Age = user.Age;
        Name = user.Name;
        Email = user.Email;
        Password = user.Password;
        PhoneNumber = user.PhoneNumber;
    }
}