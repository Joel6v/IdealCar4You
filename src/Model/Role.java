package Model;

import java.util.Arrays;

public enum Role {
    ADMIN("Administrator"),
    CUSTOMER_CONSULTANT ("Customer Consultant"),
    VEHICLE_FLEET_MANAGER ("Vehicle Fleet Manager");

    private final String fullName;

    Role(String fullName){
        this.fullName = fullName;
    }

    public String toString(){
        return fullName;
    }

    public static int indexOf(Role role){
        return Arrays.stream(Role.values()).toList().indexOf(role);
    }
}
