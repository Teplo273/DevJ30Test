

package transfer.TCPRequests;

import transfer.TCPRequests.ClientRequests.ClientRequestTypeImpl;
import java.io.Serializable;
import transfer.objects.DictionaryItem;

/**
 *
 * @author kirill
 */
public class Request implements Serializable{
    
    private final ClientRequestTypeImpl type;
    private String command;
    private DictionaryItem item;
    private int id;

    public Request(ClientRequestTypeImpl type) {
        this.type = type;
        
        
    }

    public ClientRequestTypeImpl getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public DictionaryItem getItem() {
        return item;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
    
    public void setItem(DictionaryItem item) {
        this.item = item;
    }
    
    public void setId(int id) {
        this.id = id;
    }

}
