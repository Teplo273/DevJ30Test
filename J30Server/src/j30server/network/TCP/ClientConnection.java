package j30server.network.TCP;

import java.io.Serializable;

/**
 *
 * @author kirill
 */
public interface ClientConnection extends Runnable{
    
    public <E extends Serializable> void send(E data);
    
}
