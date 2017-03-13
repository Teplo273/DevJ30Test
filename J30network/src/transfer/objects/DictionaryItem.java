package transfer.objects;

import java.io.Serializable;
import java.util.LinkedList;

public class DictionaryItem implements Serializable{
    
    private final String eng;
    private LinkedList<String> rus = new LinkedList<>();
    private int id;
    

    public DictionaryItem(String word) {
        this.eng = word;
    }

    public DictionaryItem(String word, String rus) {
        this.eng = word;
        this.rus.add(rus);
    }

    public void addMeaning(String rus) {
        this.rus.add(rus);
    }

    public String getWord() {
        return eng;
    }

    public LinkedList<String> getMeanings() {
        return rus;
    }

    public int getId() {
        return id;
    }
    
    
    

}
