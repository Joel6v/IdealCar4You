package Model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Person {
    protected String firstName;
    protected String lastName;
    protected String street;
    protected String plz;
    protected String city;
    protected String phoneNumberMobile;
    protected String email;
    protected LocalDate birthDate;

    protected DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public Person(){
    }

    public Person(String firstName, String lastName, String street, String plz, String city,
                  String phoneNumberMobile, String email, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.plz = plz;
        this.city = city;
        this.phoneNumberMobile = phoneNumberMobile;
        this.email = email;
        this.birthDate = birthDate;
    }

    public Person(String firstName, String lastName, String address,
                  String phoneNumberMobile, String email, String birthDate) throws InvalidAddressException, DateTimeParseException {
        this.firstName = firstName;
        this.lastName = lastName;
        setAddress(address);
        this.phoneNumberMobile = phoneNumberMobile;
        this.email = email;
        setBirthDateString(birthDate);
    }

    public String toString(){
        return firstName + " " + lastName + "; " + getAge();
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

    public String getAddress(){
        return street + ", " + plz + " " + city;
    }

    public void setAddress(String address) throws InvalidAddressException {
        int indexComma = address.indexOf(',');
        int indexSpace = address.indexOf(' ');
        if (indexComma == -1 || indexSpace == -1){
            throw new InvalidAddressException();
        }

        street = address.substring(0, indexComma); //is never null
        plz = address.substring(indexComma + 1, indexSpace);
        city = address.substring(indexSpace + 1);
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

    public String getBirthDateString(){
        return LocalDateFormatter.dateToString(birthDate);
    }

    public void setBirthDateString(String birthDateString) throws DateTimeParseException {
        birthDate = LocalDateFormatter.stringToDate(birthDateString);
    }

    public int getAge(){
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public boolean searchPerson(String lastName, String firstName){
        return this.lastName.equalsIgnoreCase(lastName) && this.firstName.equalsIgnoreCase(firstName);
    }
}
