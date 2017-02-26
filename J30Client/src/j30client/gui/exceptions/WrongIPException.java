package j30client.gui.exceptions;

public class WrongIPException extends Exception{
    
    private final String message;

    public WrongIPException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ("message" + " wrong IP format.");
    }
    
    
    
    

}
