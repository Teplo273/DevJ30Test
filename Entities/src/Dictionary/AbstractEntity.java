package Dictionary;

import java.io.Serializable;

/**
 *
 * @author kirill
 */
public class AbstractEntity  implements Serializable{
    
    protected int id;

    public AbstractEntity() {
        
    }

    public int getId() {
        return id;
    }
    
}
