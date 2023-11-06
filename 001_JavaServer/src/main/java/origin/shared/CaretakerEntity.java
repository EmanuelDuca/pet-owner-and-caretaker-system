package origin.shared;

public class CaretakerEntity extends UserEntity
{
    public CaretakerEntity(String username, String password)
    {
        super(username, password);
    }

    public CaretakerEntity(String username, String password, int age, String phone, String email)
    {
        super(username, password, age, phone, email);
    }

    public CaretakerEntity()
    {
        super();
    }
}
