package j30server.sqlDB;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author kirill
 */
public interface Reader<E extends Serializable> {
    
    public E read(int id);
    
    public E[] readAll();
    
    public E read(String key, String value);
    
    public int size();
    
    public ArrayList getList();
    
}
