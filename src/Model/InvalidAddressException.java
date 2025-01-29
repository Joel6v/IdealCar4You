package Model;

public class InvalidAddressException extends Exception {

    public InvalidAddressException() {
        super("An exception occurred when converting the address");
    }
}
