package Dictionary;

import java.sql.Date;

/**
 *
 * @author kirill
 */
public class Meaning extends AbstractEntity{
    
    private String value;
    
    private Date date;
    
    private String authorName;

    public Meaning(int id, String value, String name) {
        super(id);
        this.value = value;
        this.authorName = name;
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

    
}
