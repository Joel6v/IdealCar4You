package Model;

import java.time.LocalDate;

public class User extends Person{
    private Role role;

    public User() {}

    public User(String firstName, String lastName, String street, String plz, String city, String phoneNumberPrivate,
                String phoneNumberMobile, String email, LocalDate birthDate, Role role) {
        super(firstName, lastName, street, plz, city, phoneNumberPrivate, phoneNumberMobile, email, birthDate);
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
