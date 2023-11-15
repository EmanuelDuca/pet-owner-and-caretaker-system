package dk.via.sep3.shared;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PetOwnerEntity extends UserEntity implements Serializable {

    public PetOwnerEntity(String username, String password)
    {
        super(username, password);
    }

    public PetOwnerEntity(String username, String password, int age, String phone, String email, String type)
    {
        super(username, password, phone, age, email,type);
    }

    public PetOwnerEntity()
    {
        super();
    }
}
