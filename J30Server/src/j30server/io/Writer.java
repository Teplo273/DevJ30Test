package j30server.io;

/**
 *
 * @author kirill
 */
public interface Writer<E> {
    
    public void write(E data);
    
    public void delete(int id);
    
    public void delete(String key, String value);
    
}
