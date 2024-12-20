package Model;

import java.time.LocalDate;

public class Van extends Vehicle {
    private int maxLoad;

    public Van() {
    }

    public Van(String brand, String model, double displacement, Fuel fuel,
               int currentKm, double power, LocalDate firstRegistration, String color, int emptyWeigth, int maxLoad) {
        super(brand, model, displacement, fuel, currentKm, power, firstRegistration, color, emptyWeigth);
        this.maxLoad = maxLoad;
    }

    public int getMaxLoad() {
        return maxLoad;
    }

    public void setMaxLoad(int maxLoad) {
        this.maxLoad = maxLoad;
    }
}
