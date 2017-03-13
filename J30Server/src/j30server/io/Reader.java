package j30server.io;

import java.util.ArrayList;
import transfer.objects.ItemForList;

/**
 *
 * @author kirill
 */
public interface Reader<E> {
    
    public E read(int id);
    
    public E[] readAll();
    
    public E read(String key, String value);
    
    public int size();
    
    public ArrayList<ItemForList> getList();
    
}
