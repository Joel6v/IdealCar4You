package Model;

import java.time.LocalDate;

public class Customer extends Person {
    private LocalDate createdAt;

    public Customer(){}

    public Customer(String firstName, String lastName, String street, String plz,
                    String city, String phoneNumberMobile, String email, LocalDate birthDate, LocalDate createdAt) {
        super(firstName, lastName, street, plz, city, phoneNumberMobile, email, birthDate);
        this.createdAt = createdAt;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
