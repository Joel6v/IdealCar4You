package Model;

import java.util.Arrays;

public enum Structure {
    CABRIOLET ("Cabriolet"),
    COMBI ("Combi"),
    LIMOUSINE ("Limousine"),
    SMALL_CAR ("Small Car"),
    SUV ("SUV");

    private final String fullName;

    Structure(String fullName){
        this.fullName = fullName;
    }

    @Override
    public String toString(){
        return fullName;
    }

    public static int indexOf(Structure structure){
        return Arrays.stream(Structure.values()).toList().indexOf(structure);
    }
}
