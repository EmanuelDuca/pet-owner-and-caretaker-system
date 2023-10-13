namespace Domain.Models;

public abstract class User
{
    public string Name { get; set; }
    public int? Age { get; set; }
    public string Email { get; set; }
    public int? PhoneNumber { get; set; }
    public string Password { get; set; }
    public string Type { get; }

    public User(string name, string email, string password)
    {
        Name = name;
        Email = email;
        Password = password;
    }
    
    public User(string name, string email, string password, string type)
    {
        Name = name;
        Email = email;
        Password = password;
        Type = type;
    }

    public User(string name, string email, string password, string type, int age, int phonenumber)
    {
        Name = name;
        Email = email;
        Password = password;
        Type = type;
        Age = age;
        PhoneNumber = phonenumber;
    }

    public abstract string toString();
}