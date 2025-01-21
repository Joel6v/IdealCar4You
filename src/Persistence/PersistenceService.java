package Persistence;

import Model.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

    public Object readObjectList(Object objectExample) {
        List<Object> objectsList = new ArrayList<>();

        String currentFileName;
        if (objectExample instanceof Vehicle) {
            currentFileName = fileNameVehicle;
        } else if (objectExample instanceof Customer) {
            currentFileName = fileNameCustomer;
        } else {
            currentFileName = fileNameUser;
        }

        try {
            File jsonFile = new File(currentFileName);

            if (jsonFile.exists()) {
                Object[] objectArray = mapper.readValue(jsonFile, Object[].class);
                for (Object obj : objectArray) {
                    objectsList.add(obj);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return objectsList;
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
}
