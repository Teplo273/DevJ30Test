package transfer.objects;

import java.io.Serializable;
import java.util.LinkedList;

public class DictionaryItem implements Serializable{
    
    private final String word;
    private LinkedList<String> meanings = new LinkedList<>();
    private int id;
    

    public DictionaryItem(String word) {
        this.word = word;
    }

    public DictionaryItem(String word, String meaning) {
        this.word = word;
        this.meanings.add(meaning);
    }

    public void addMeaning(String meaning) {
        this.meanings.add(meaning);
    }

    public String getWord() {
        return word;
    }

    public LinkedList<String> getMeanings() {
        return meanings;
    }

    public int getId() {
        return id;
    }
    
    
    

}
