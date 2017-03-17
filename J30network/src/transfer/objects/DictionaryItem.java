package transfer.objects;

import java.io.Serializable;
import java.util.LinkedList;

public class DictionaryItem implements Serializable{
    
    private final String name;
    private LinkedList<String> meanings = new LinkedList<>();
    private int id;
    

    public DictionaryItem(String word) {
        this.name = word;
    }

    public DictionaryItem(String word, String meaning) {
        this.name = word;
        this.meanings.add(meaning);
    }

    public void addMeaning(String meaning) {
        this.meanings.add(meaning);
    }

    public String getWord() {
        return name;
    }

    public LinkedList<String> getMeanings() {
        return meanings;
    }

    public int getId() {
        return id;
    }
    
    public void removeMeaning (int index) {
        meanings.remove(index);
    }
    
    
    

}
