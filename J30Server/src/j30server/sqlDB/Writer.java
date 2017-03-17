package j30server.sqlDB;

import java.io.Serializable;

/**
 *
 * @author kirill
 */
public interface Writer<E extends Serializable> {
    
    public void write(E data);
    
    public void delete(int id);
    
    public void delete(String key, String value);
    
}
