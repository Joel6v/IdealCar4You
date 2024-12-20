package Model;

import java.time.LocalDate;

abstract public class Vehicle {
    protected String brand;
    protected String model;
    protected double displacement;
    protected Fuel fuel;
    protected int currentKm;
    protected double power;
    protected LocalDate firstRegistration;
    protected String color;
    protected int emptyWeigth;

    public Vehicle() {
    }

    public Vehicle(String brand, String model, double displacement, Fuel fuel, int currentKm, double power, LocalDate firstRegistration, String color, int emptyWeigth) {
        this.brand = brand;
        this.model = model;
        this.displacement = displacement;
        this.fuel = fuel;
        this.currentKm = currentKm;
        this.power = power;
        this.firstRegistration = firstRegistration;
        this.color = color;
        this.emptyWeigth = emptyWeigth;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getDisplacement() {
        return displacement;
    }

    public void setDisplacement(double displacement) {
        this.displacement = displacement;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    public int getCurrentKm() {
        return currentKm;
    }

    public void setCurrentKm(int currentKm) {
        this.currentKm = currentKm;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public LocalDate getFirstRegistration() {
        return firstRegistration;
    }

    public void setFirstRegistration(LocalDate firstRegistration) {
        this.firstRegistration = firstRegistration;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getEmptyWeigth() {
        return emptyWeigth;
    }

    public void setEmptyWeigth(int emptyWeigth) {
        this.emptyWeigth = emptyWeigth;
    }
}
