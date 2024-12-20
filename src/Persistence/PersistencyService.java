package Persistence;

import Model.*;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class PersistencyService {
    private final String fileNameVehicle = "Vehicles.json";
    private final String fileNameCostumer = "Costumer.json";
    private final String fileNameUser = "User.json";

    public List<Object> readObjectList(){
        return null;
    }

    public void saveObjectList(List<Object> objectsList){
        if(objectsList.get(0) instanceof Vehicle){

        } else if (objectsList.get(0) instanceof Customer) {

        }else{

        }
    }
}
