package j30client.helpers;

import java.util.EventListener;

public interface Listened<E extends EventListener> {
    
    
    public void addListener(E listener);
    
    public void removeListener(E listener);
    
    
    
    
}
