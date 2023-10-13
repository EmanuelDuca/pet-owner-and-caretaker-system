namespace Domain.Models;

public class CareTaker : User
{
    public CareTaker(string name, string email, string password, string type) : base(name, email, password,type)
    { }

    public override string toString()
    {
        return $"CareTaker: {Name}";
    }
}