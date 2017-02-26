package j30client.network;

import java.io.Serializable;

public interface Connector<E extends Serializable> {

    //public <E extends Serializable> void send(E data) throws IOException;
    
    public E findByWord(String word);
    
    public void findByMeaning(String meaning);
    
    public void saveItem(E item);
    
    public void deleteItem(int id);
    
    public void disconnect();

}
