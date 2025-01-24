package Model;

import Persistence.PersistenceService;

import java.util.ArrayList;
import java.util.List;

public class CarDealerModel {
    private List<Vehicle> vehiclesList ;
    private List<Customer> customerList;
    private List<User> usersList;
    PersistenceService persistenceService;

    public CarDealerModel() {
        this.persistenceService = new PersistenceService();
        vehiclesList = persistenceService.readVehicleList();
        customerList = persistenceService.readCustomerList();
        usersList = persistenceService.readUserList();
    }

    //Vehicle
    public Vehicle getVehicle(int index) {
        return vehiclesList.get(index);
    }

    public List<Vehicle> getVehicle() {
        return vehiclesList;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehiclesList.add(vehicle);
        persistenceService.saveObjectList(vehiclesList);
    }

    public void addVehicle(List<Vehicle> vehicles) {
        this.vehiclesList.addAll(vehicles);
        persistenceService.saveObjectList(vehiclesList);
    }

    public void updateVehicle(int index, Vehicle vehicle) {
        this.vehiclesList.set(index, vehicle);
        persistenceService.saveObjectList(vehiclesList);
    }

    public void deleteVehicle(int index) {
        this.vehiclesList.remove(index);
        persistenceService.saveObjectList(vehiclesList);
    }

    //Customer
    public Customer getCustomer(int index) {
        return customerList.get(index);
    }

    public List<Customer> getCustomer() {
        return customerList;
    }

    public void addCustomer(Customer customer) {
        this.customerList.add(customer);
        persistenceService.saveObjectList(customerList);
    }

    public void addCustomer(List<Customer> customers) {
        this.customerList.addAll(customers);
        persistenceService.saveObjectList(customerList);
    }

    public void updateCustomer(int index, Customer customer) {
        this.customerList.set(index, customer);
        persistenceService.saveObjectList(customerList);
    }

    public void deleteCustomer(int index) {
        this.customerList.remove(index);
        persistenceService.saveObjectList(customerList);
    }

    //User
    public User getUser(int index) {
        return usersList.get(index);
    }

    public List<User> getUser() {
        return usersList;
    }

    public void addUser(User user) {
        this.usersList.add(user);
        persistenceService.saveObjectList(usersList);
    }

    public void addUser(List<User> users) {
        this.usersList.addAll(users);
        persistenceService.saveObjectList(usersList);
    }

    public void updateUser(int index, User user) {
        this.usersList.set(index, user);
        persistenceService.saveObjectList(usersList);
    }

    public void deleteUser(int index) {
        this.usersList.remove(index);
        persistenceService.saveObjectList(usersList);
    }
}
