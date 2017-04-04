

package transfer.TCPRequests;

import Dictionary.Item;
import transfer.TCPRequests.ClientRequests.ClientRequestType;
import java.io.Serializable;

/**
 *
 * @author kirill
 */
public class Request implements Serializable{
    
    private final ClientRequestType type;
    private Item item;
    private int id;

    public Request(ClientRequestType type) {
        this.type = type;
    }

    public ClientRequestType getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
    
    public void setId(int id) {
        this.id = id;
    }

}
