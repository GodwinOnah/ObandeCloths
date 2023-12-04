package obandecloths;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class UserX {

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
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phone;
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserX signup = (UserX) o;
        return Objects.equals(userId, signup.userId) && Objects.equals(firstName, signup.firstName) && Objects.equals(lastName, signup.lastName) && Objects.equals(email, signup.email) && Objects.equals(address, signup.address) && Objects.equals(phone, signup.phone) && Objects.equals(password, signup.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, email, address, phone, password);
    }

    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserX(Integer userId, String firstName, String lastName, String email, String address, String phone, String password) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.password = password;
    }

    public UserX(){}
}


