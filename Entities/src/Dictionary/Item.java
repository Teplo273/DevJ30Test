package Dictionary;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author kirill
 */
public final class Item extends AbstractEntity {

    private final String itemName;

    private Date date;

    private String authorName;

    private LinkedList<Meaning> mList = new LinkedList<>();

    public Item(String name) {
        this.itemName = name;
    }

    public Item(int id, String name) {
        this.id = id;
        this.itemName = name;
    }

    public Item(String itemName, Date date, String authorName) {
        this.itemName = itemName;
        this.date = date;
        this.authorName = authorName;
    }

    public Item(int id, String itemName, Date date, String authorName) {
        this.id = id;
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

    public void addMeaning(Meaning meaning) {
        mList.add(meaning);
    }
    
    public void setMeaning(LinkedList meanings){
        mList = meanings;
    }

    public List getMeanings() {
        return mList;
    }

}
