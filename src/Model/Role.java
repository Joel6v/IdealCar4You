package Model;

public enum Role {
    VEHICLE_FLEET_MANAGER ("Vehicle Fleet Manager"),
    CUSTOMER_CONSULTANT ("Customer Consultant"),
    ADMIN("Administrator"),;

    Role(String name){

    }

    public String toString(){
        return this.name();
    }
}
