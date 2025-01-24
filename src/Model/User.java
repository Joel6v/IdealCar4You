package Model;

import java.time.LocalDate;

public class User extends Person{
    private Role role;
    private String password;

    public User() {}

    public User(String firstName, String lastName, String street, String plz, String city, String phoneNumberPrivate,
                String phoneNumberMobile, String email, LocalDate birthDate, Role role, String password) {
        super(firstName, lastName, street, plz, city, phoneNumberMobile, email, birthDate);
        this.role = role;
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean validateLogin(String lastName, String firstName, String password) {
        return this.lastName.equalsIgnoreCase(lastName) && this.firstName.equalsIgnoreCase(firstName) && this.password.equals(password);
    }
}
