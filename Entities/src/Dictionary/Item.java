package Dictionary;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author kirill
 */
public class Item extends AbstractEntity{
    
    private final String itemName;
    
    private Date date;
    
    private String authorName;
    
    private LinkedList<Meaning> mList = new LinkedList<>();

    public Item(int id, String name) {
        super(id);
        this.itemName = name;
    }

    public Item(int id, String itemName, Date date, String authorName) {
        super(id);
        this.itemName = itemName;
        this.date = date;
        this.authorName = authorName;
    }
    
    


    public String getItemName() {
        return itemName;
    }

    public Date getDate() {
        return date;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    
    public void addMeaning(Meaning meaning){
        mList.add(meaning);
    }
    
    public List getMeanings(){
        return mList;
    }
    
    
    
    
    
    
    
}
