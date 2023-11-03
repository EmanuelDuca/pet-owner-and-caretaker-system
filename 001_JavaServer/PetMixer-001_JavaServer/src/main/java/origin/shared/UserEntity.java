package origin.shared;

import java.io.Serializable;

public class UserEntity implements Serializable {
    private String username;
    private String password;
    private int age;
    private String phone;
    private String email;

    public UserEntity(String username, String password) {
        this.email = username;
        this.password = password;
    }

    public UserEntity(String username, String password, int age, String phone, String email) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }


    public UserEntity() {
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

    @Override
    public String toString() {
        return "PetOwnerEntity{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
