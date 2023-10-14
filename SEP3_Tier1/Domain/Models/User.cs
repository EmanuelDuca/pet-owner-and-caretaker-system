namespace Domain.Models;

public abstract class User
{
    public string Name { get; set; }
    public int? Age { get; set; }
    public string Email { get; set; }
    public int? PhoneNumber { get; set; }
    public string Password { get; set; }
    public string Type { get; } // todo - check this, I doubt that we need this, I agree that for creation we need a field to identify the user type.
                                // But we have inheritance (abstraction) and we can use it, no reason to store "type" of User in a string
                                // For example in UserLogic... u can create PetOwner object in case if type property from UserCreationDto is "PetOwner"

    // todo - u also have strange approach to constructors, it's not java you can use a general constructor. Other properties can be initialized through setters.
    // Or u can delete all constructors than you are free to set all fields where needed on your own, like we did in the tutorial, there also weren't used constructors in models classes I think.
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