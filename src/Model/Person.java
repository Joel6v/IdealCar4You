package Model;

import java.time.LocalDate;

public class Person {
    protected String firstName;
    protected String lastName;
    protected String street;
    protected String plz;
    protected String city;
    protected String phoneNumberPrivate;
    protected String phoneNumberMobile;
    protected String email;
    protected LocalDate birthDate;

    public Person(){
    }

    public Person(String firstName, String lastName, String street, String plz, String city,
                  String phoneNumberPrivate, String phoneNumberMobile, String email, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.plz = plz;
        this.city = city;
        this.phoneNumberPrivate = phoneNumberPrivate;
        this.phoneNumberMobile = phoneNumberMobile;
        this.email = email;
        this.birthDate = birthDate;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumberPrivate() {
        return phoneNumberPrivate;
    }

    public void setPhoneNumberPrivate(String phoneNumberPrivate) {
        this.phoneNumberPrivate = phoneNumberPrivate;
    }

    public String getPhoneNumberMobile() {
        return phoneNumberMobile;
    }

    public void setPhoneNumberMobile(String phoneNumberMobile) {
        this.phoneNumberMobile = phoneNumberMobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
