package javax.io;

import java.io.IOException;
import java.io.Serializable;

public interface Storage<E extends Serializable> {

    void save(E data) throws IOException;
    
    E load() throws IOException;
    
}
