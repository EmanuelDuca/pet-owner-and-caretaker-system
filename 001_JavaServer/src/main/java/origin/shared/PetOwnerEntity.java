package origin.shared;

public class PetOwnerEntity extends UserEntity
{
    public PetOwnerEntity(String username, String password)
    {
        super(username, password);
    }

    public PetOwnerEntity(String username, String password, int age, String phone, String email)
    {
        super(username, password, age, phone, email);
    }

    public PetOwnerEntity()
    {
        super();
    }
}
