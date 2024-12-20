package Model;

import java.util.ArrayList;
import java.util.List;

public class CarDealerModel {
    private List<Vehicle> vehicles = new ArrayList<>();
    private List<Customer> customer = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public CarDealerModel() {

    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public void updateVehicle(int index, Vehicle vehicle) {
        this.vehicles.set(index, vehicle);
    }

    public void deleteVehicle(int index) {
        this.vehicles.remove(index);
    }

    public List<Customer> getCustomer() {
        return customer;
    }

    public void addCustomer(Customer customer) {
        this.customer.add(customer);
    }

    public void updateCustomer(int index, Customer customer) {
        this.customer.set(index, customer);
    }

    public void deleteCustomer(int index) {
        this.customer.remove(index);
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void updateUser(int index, User user) {
        this.users.set(index, user);
    }

    public void deleteUser(int index) {
        this.users.remove(index);
    }
}
