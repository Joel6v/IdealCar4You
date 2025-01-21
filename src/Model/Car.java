package Model;

import java.time.LocalDate;

public class Car extends Vehicle{
    private Structure structure;
    private boolean navigation;

    public Car() {
    }

    public Car(String brand, String model, double displacement, Fuel fuel,
               int currentKm, double power, LocalDate firstRegistration, int emptyWeigth, Structure structure) {
        super(brand, model, displacement, fuel, currentKm, power, firstRegistration, emptyWeigth);
        this.structure = structure;
    }

    public Structure getStructure() {
        return structure;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }

    public boolean isNavigation() {
        return navigation;
    }

    public void setNavigation(boolean navigation) {
        this.navigation = navigation;
    }
}
