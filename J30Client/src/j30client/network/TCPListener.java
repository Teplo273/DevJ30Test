package j30client.network;

import java.io.Serializable;
import java.util.EventListener;

public interface TCPListener extends EventListener{

    public <E extends Serializable>void dataReceived(E data);

}
