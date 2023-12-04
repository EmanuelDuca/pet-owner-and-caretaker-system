package dk.via.sep3.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user_entity")
public class UserEntity implements Serializable
{
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
    protected String userType;

    // if want to delete all related entities in related tables automatically
    // This cane be reached via next line
    @OneToMany(mappedBy = "careTaker", cascade = CascadeType.ALL, orphanRemoval = true)
    protected Set<CalendarEntity> datePeriods;


    public UserEntity(String username, String password) {
        this.email = username;
        this.password = password;
    }


    public UserEntity() {


    }

    public UserEntity(String email, String username, String password, String userType) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public UserEntity(String email, String username, String password, String userType, Integer age, String phone, String name) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.age = age;
        this.userType = userType;
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

    public String getUserType()
    {
        return userType;
    }

    public void setUserType(String userType)
    {
        this.userType = userType;
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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof UserEntity that)) return false;
        return Objects.equals(email, that.email) && Objects.equals(username, that.username) && Objects.equals(name, that.name) && Objects.equals(password, that.password) && Objects.equals(age, that.age) && Objects.equals(phone, that.phone) && Objects.equals(userType, that.userType);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(email, username, name, password, age, phone, userType);
    }
}