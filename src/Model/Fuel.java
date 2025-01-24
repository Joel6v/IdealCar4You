package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

public enum Fuel {
    DIESEL ("DIESEL"),
    ELECTRIC ("ELECTRIC"),
    GASOLINE95 ("GASOLINE ROZ 95"),
    GASOLINE98 ("GASOLINE ROZ 98");

    private final String fullName;

    Fuel(String fullName){
        this.fullName = fullName;
    }

    @Override
    public String toString(){
        return fullName;
    }

    public static int indexOf(Fuel fuel){
        return Arrays.stream(Fuel.values()).toList().indexOf(fuel);
    }
}
