package dk.via.sep3.shared;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_entity")
public class UserEntity implements Serializable {
    @Id
    @Column(unique = true)
    protected String email;
    protected String username;

    @Column(nullable = true)
    protected String name;
    protected String password;
    @Column(nullable = true)
    protected Integer age;
    @Column(nullable = true)
    protected String phone;


    public UserEntity(String username, String password) {
        this.email = username;
        this.password = password;
    }


    public UserEntity() {
    }

    public UserEntity(String email, String username, String password, Integer age, String phone, String name) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.age = age;
        this.phone = phone;
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public UserEntity setName(String name)
    {
        this.name = name;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}