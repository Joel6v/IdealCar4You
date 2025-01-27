package Persistence;

import Model.*;
import com.fasterxml.jackson.databind.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersistenceService {
    private final String fileNameVehicle = "Vehicles.json";
    //private final String fileNamePerson = "Persons.json";
    private final String fileNameCustomer = "Costumer.json";
    private final String fileNameUser = "User.json";
    private ObjectMapper mapper;

    public PersistenceService() {
        mapper = new ObjectMapper();
    }

    public ArrayList<Vehicle> readVehicleList() {
        ArrayList<Vehicle> vehiclesList = new ArrayList<>();

        try {
            File jsonFile = new File(fileNameVehicle);
            if (jsonFile.exists()) {
                vehiclesList.addAll(Arrays.asList(mapper.readValue(jsonFile, Vehicle[].class)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return vehiclesList;
    }

    public ArrayList<Customer> readCustomerList() {
        ArrayList<Customer> customersList = new ArrayList<>();

        try {
            File jsonFile = new File(fileNameCustomer);
            if (jsonFile.exists()) {
                customersList.addAll(Arrays.asList(mapper.readValue(jsonFile, Customer[].class)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return customersList;
    }

    public ArrayList<User> readUserList() {
        ArrayList<User> usersList = new ArrayList<>();

        try {
            File jsonFile = new File(fileNameUser);
            if (jsonFile.exists()) {
                usersList.addAll(Arrays.asList(mapper.readValue(jsonFile, User[].class)));
            }else{
                usersList.addAll(preFabUsers());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return usersList;
    }

    public void saveObjectList(Object objectsList) {
        String currentFileName;
        if (objectsList instanceof Vehicle) {
            currentFileName = fileNameVehicle;
        } else if (objectsList instanceof Customer) {
            currentFileName = fileNameCustomer;
        } else {
            currentFileName = fileNameUser;
        }

        try {
            File jsonFile = new File(currentFileName);
            mapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, objectsList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<User> preFabUsers() {
        List<User> usersList = new ArrayList<>();
        User admin = new User("", "Admin", "", "", "", "", "", "",
                LocalDate.now(), Role.ADMIN, "Admin123");
        usersList.add(admin);
        return usersList;
    }
}
