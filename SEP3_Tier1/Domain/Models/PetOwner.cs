namespace Domain.Models;

public class PetOwner : User
{
    public PetOwner(string name, string email, string password, string type) : base(name, email, password, type)
    {
        Name = name;
        Email = email;
        Password = password;
    }

    public PetOwner(string name, string email, string password) : base(name, email, password)
    {
        Name = name;
        Email = email;
        Password = password;
    }

    public override string toString()
    {
        return $"PetOwner: {Name}";
    }
}