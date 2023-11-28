package obandecloths;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class User {

    @Id
    @SequenceGenerator(
            name = "",
            sequenceName = "user_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_id_sequence"
    )
    private Integer UserId;
    private String FirstName;
    private String LastName;
    private String Email;
    private String Address;
    private String Phone;
    private String Password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User signup = (User) o;
        return Objects.equals(UserId, signup.UserId) && Objects.equals(FirstName, signup.FirstName) && Objects.equals(LastName, signup.LastName) && Objects.equals(Email, signup.Email) && Objects.equals(Address, signup.Address) && Objects.equals(Phone, signup.Phone) && Objects.equals(Password, signup.Password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(UserId, FirstName, LastName, Email, Address, Phone, Password);
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String secondName) {
        LastName = secondName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public User(Integer userId, String firstName, String secondName, String email, String address, String phone, String password) {
        UserId = userId;
        FirstName = firstName;
        LastName = secondName;
        Email = email;
        Address = address;
        Phone = phone;
        Password = password;
    }

    public User(){}
}


