package Controller;

import Model.CarDealerModel;
import Model.Customer;
import Model.User;
import Model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class CarDealerController {
    private List<Vehicle> vehiclesList;
    private List<Customer> customersList;
    private List<User> usersList;
    User currentUser;
    CarDealerModel model;

    public CarDealerController(CarDealerModel carDealerModel) {
        this.model = carDealerModel;
        vehiclesList = model.getVehicle();
        customersList = model.getCustomer();
        usersList = model.getUser();
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
        customersList.add(customer);
    }

    public void addUser(User user) {
        usersList.add(user);
    }

    public Vehicle getVehicle(int id) {
        return vehiclesList.get(id);
    }

    public Customer getCustomer(int id) {
        return customersList.get(id);
    }

    public User getUser(int id) {
        return usersList.get(id);
    }

    public ArrayList<Vehicle> getVehicle() {
        return (ArrayList<Vehicle>) vehiclesList;
    }

    public ArrayList<Customer> getCustomer() {
        return (ArrayList<Customer>) customersList;
    }

    public ArrayList<User> getUser() {
        return (ArrayList<User>) usersList;
    }

    public void updateVehicle(int index, Vehicle vehicle) {
        vehiclesList.set(index, vehicle);
    }

    public void updateCustomer(int index, Customer customer) {
        customersList.set(index, customer);
    }

    public void updateUser(int index, User user) {
        usersList.set(index, user);
    }

    public void deleteVehicle(int id) {
        vehiclesList.remove(id);
    }

    public void deleteCustomer(int id) {
        customersList.remove(id);
    }

    public void deleteUser(int id) {
        usersList.remove(id);
    }

    public boolean validateLogin(String lastName, String firstName, String password) {
        for(User user : usersList) {
            if(user.validateLogin(lastName, firstName, password)) {
                currentUser = user;
                return true;
            }
        }

        return false;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUserNull(){
        currentUser = null;
    }

    public int searchVehicle(String search) {
        String brand = search.substring(0, search.indexOf(';'));
        String model = search.substring(search.indexOf(';') + 1);
        for(int i = 0; i < vehiclesList.size(); i++) {
            if(vehiclesList.get(i).searchVehicle(brand, model)) {
                return i;
            }
        }

        return -1;
    }

    public int searchCustomer(String search) {
        String lastName = search.substring(0, search.indexOf(';'));
        String firstName = search.substring(search.indexOf(';') + 1);

        for(int i = 0; i < customersList.size(); i++) {
            if(customersList.get(i).searchPerson(lastName, firstName)) {
                return i;
            }
        }

        return -1;
    }

    public int searchUser(String search) {
        String lastName = search.substring(0, search.indexOf(';'));
        String firstName = search.substring(search.indexOf(';') + 1);

        for(int i = 0; i < usersList.size(); i++) {
            if(usersList.get(i).searchPerson(lastName, firstName)) {
                return i;
            }
        }

        return -1;
    }
}
