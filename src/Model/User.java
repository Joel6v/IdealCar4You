package Model;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.Arrays;

public class User extends Person{
    private Role role;
    private byte[] password;

    public User() {}

    public User(String firstName, String lastName, String street, String plz, String city, String phoneNumberPrivate,
                String phoneNumberMobile, String email, LocalDate birthDate, Role role, byte[] password) {
        super(firstName, lastName, street, plz, city, phoneNumberMobile, email, birthDate);
        this.role = role;
        this.password = password;
    }

    public User(String firstName, String lastName, String street, String plz, String city, String phoneNumberPrivate,
                String phoneNumberMobile, String email, LocalDate birthDate, Role role, String password) {
        super(firstName, lastName, street, plz, city, phoneNumberMobile, email, birthDate);
        this.role = role;
        setPassword(password);
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setPassword(String password) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        this.password = digest.digest(password.getBytes(StandardCharsets.UTF_8));
    }

    public boolean validateLogin(String lastName, String firstName, String inputPasswordStr) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] inputPassword = digest.digest(inputPasswordStr.getBytes(StandardCharsets.UTF_8));
        return this.lastName.equalsIgnoreCase(lastName) && this.firstName.equalsIgnoreCase(firstName) && Arrays.equals(password, inputPassword);
    }
}
