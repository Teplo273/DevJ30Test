package j30server.network;

public class RMIConnectionServer implements Server{
    
    private final String BINDING_NAME = "DictionaryService";

    @Override
    public void run() {
        
    }

    @Override
    public void stopServer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
