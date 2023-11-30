package dk.via.sep3.shared;

import dk.via.sep3.shared.UserEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;
import java.util.Set;

@Entity
public class CareTakerEntity extends UserEntity
{
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "careTaker")
    private Set<CaretakerTimePeriod> timePeriod;
    public CareTakerEntity(UserEntity user)
    {
        email = user.getEmail();
        username = user.getUsername();
        password = user.getPassword();
        phone = user.getPhone();
        age = user.getAge();
        name = user.getName();
    }

    public CareTakerEntity()
    {

    }
}
