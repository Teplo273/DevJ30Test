package transfer.objects;

import java.io.Serializable;

/**
 *
 * @author kirill
 */
public class ItemForList implements Serializable{
    
    private final int id;
    
    private final String primaryKey;

    public ItemForList(int id, String primaryKey) {
        this.id = id;
        this.primaryKey = primaryKey;
    }

    public int getId() {
        return id;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }
    
    

}
