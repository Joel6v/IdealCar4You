package Model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.FormatFlagsConversionMismatchException;

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

    public String toString(){
        return firstName + " " + lastName + " " + getAge();
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

    public String getAdress(){
        return street + ", " + plz + " " + city;
    }

    public void setAdress(String adress) throws Exception {
        Exception invalidAdressException = new Exception("Invalid adress");
        int indexComma = adress.indexOf(',');
        int indexSpace = adress.indexOf(' ');
        if (indexComma == -1 || indexSpace == -1){
            throw invalidAdressException;
        }

        street = adress.substring(0, indexComma); //is never null
        plz = adress.substring(indexComma + 1, indexSpace);
        city = adress.substring(indexSpace + 1);
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
