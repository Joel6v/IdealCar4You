package Model;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Customer extends Person {
    private LocalDate createdAt;

    public Customer(){}

    public Customer(String firstName, String lastName, String street, String plz,
                    String city, String phoneNumberMobile, String email, LocalDate birthDate, LocalDate createdAt) {
        super(firstName, lastName, street, plz, city, phoneNumberMobile, email, birthDate);
        this.createdAt = createdAt;
    }

    public Customer(String firstName, String lastName, String address,
                    String phoneNumberMobile, String email, String birthDate) throws InvalidAddressException {
        super(firstName, lastName, address, phoneNumberMobile, email, birthDate);
        createdAt = LocalDate.now();
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreateAtString(){
        return LocalDateFormatter.dateToString(createdAt);
    }

    public void setCreateAtString(String createdAt) throws DateTimeParseException {
        this.createdAt = LocalDateFormatter.stringToDate(createdAt);
    }
}
