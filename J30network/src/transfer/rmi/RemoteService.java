package transfer.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import transfer.objects.DictionaryItem;

public interface RemoteService extends Remote{
    
    public void disconect() throws RemoteException;
    
    public DictionaryItem getByWord(String word) throws RemoteException;
    
    public DictionaryItem getByWord(int id) throws RemoteException;
    
    public List<DictionaryItem> getByMeaning(String meaning) throws RemoteException;
    
    public void saveItem(DictionaryItem item) throws RemoteException;
    
    public void addNewItem(DictionaryItem item) throws RemoteException;
    
    public void deleteItem(int id) throws RemoteException;
    
    public int getDBSize() throws RemoteException;
    
}
