package Dictionary;

import java.sql.Date;

/**
 *
 * @author kirill
 */
public final class Meaning extends AbstractEntity{
    
    private String value;
    
    private Date date;
    
    private String authorName;
    
    private int itemId;

    public Meaning(String text, Date date, String author,  int itemId) {
        this.value = text;
        this.authorName = author;
        this.date = date;
        this.itemId = itemId;
    }

    public Meaning(int id, String text, Date date,String author, int itemId) {
        this.id = id;
        this.value = text;
        this.authorName = author;
        this.date = date;
        this.itemId = itemId;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public Date getDate() {
        return date;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getValue() {
        return value;
    }

    public int getItemId() {
        return itemId;
    }
    
    

    
}
