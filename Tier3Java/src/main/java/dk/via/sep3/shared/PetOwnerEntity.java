package dk.via.sep3.shared;

import dk.via.sep3.shared.UserEntity;

import javax.persistence.Entity;

@Entity
public class PetOwnerEntity extends UserEntity
{
    public PetOwnerEntity(UserEntity user)
    {
        email = user.getEmail();
        username = user.getUsername();
        password = user.getPassword();
        phone = user.getPhone();
        age = user.getAge();
        name = user.getName();
    }

    public PetOwnerEntity()
    {

    }
}
