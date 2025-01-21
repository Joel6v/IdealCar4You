package Controller;

import Model.CarDealerModel;
import Model.Customer;
import Model.User;
import Model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class CarDealerController {
    private List<Vehicle> vehiclesList = new ArrayList<>();
    private List<Customer> customerList = new ArrayList<>();
    private List<User> usersList = new ArrayList<>();
    CarDealerModel carDealerModel;
    User currentUser;

    public CarDealerController(CarDealerModel carDealerModel) {
        this.carDealerModel = carDealerModel;
    }

//    public void addItem(Object obj) {
//        if (obj instanceof Vehicle) {
//            vehiclesList.add((Vehicle) obj);
//        } else if (obj instanceof Customer) {
//            customerList.add((Customer) obj);
//        } else if (obj instanceof User) {
//            usersList.add((User) obj);
//        } else {
//            throw new IllegalArgumentException("Unsupported object type: " + obj.getClass().getName());
//        }
//    }

    public void addVehicle(Vehicle vehicle) {
        vehiclesList.add(vehicle);
    }

    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    public void addUser(User user) {
        usersList.add(user);
    }

    public Vehicle getVehicle(int id) {
        return vehiclesList.get(id);
    }

    public Customer getCustomer(int id) {
        return customerList.get(id);
    }

    public User getUser(int id) {
        return usersList.get(id);
    }

    public void updateVehicle(int index, Vehicle vehicle) {
        vehiclesList.set(index, vehicle);
    }

    public void updateCustomer(int index, Customer customer) {
        customerList.set(index, customer);
    }

    public void updateUser(int index, User user) {
        usersList.set(index, user);
    }

    public void deleteVehicle(int id) {
        vehiclesList.remove(id);
    }

    public void deleteCustomer(int id) {
        customerList.remove(id);
    }

    public void deleteUser(int id) {
        usersList.remove(id);
    }

    public User validateLogin(String lastName, String firstName, String password) {
        for(User user : usersList) {
            if(user.validateLogin(lastName, firstName, password)) {
                currentUser = user;
                return user;
            }
        }

        return null;
    }
}
