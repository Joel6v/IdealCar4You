package Model;

public enum Fuel {
    GASOLINE95 ("GASOLINE ROZ 95"),
    GASOLINE98 ("GASOLINE ROZ 98"),
    DIESEL ("DIESEL"),
    ELECTRIC ("ELECTRIC");

    Fuel(String name){

    }

    public String toString(){
        return this.name();
    }
}
