package dk.via.sep3.shared;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class UserEntity implements Serializable {
    @Id
    @Column(unique = true)
    private String email;
    private String username;
    private String name;
    private String password;
    private int age;
    private String phone;
    private String type;


    public UserEntity(String username, String password) {
        this.email = username;
        this.password = password;
    }




    public UserEntity() {
    }

    public UserEntity(String email, String username, String password, int age, String phone, String type) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.age = age;
        this.phone = phone;
        this.type = type;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}