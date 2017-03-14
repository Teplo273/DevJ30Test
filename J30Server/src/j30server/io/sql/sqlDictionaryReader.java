package j30server.io.sql;

import j30server.io.Reader;
import java.util.ArrayList;
import transfer.objects.DictionaryItem;
import transfer.objects.ItemForList;

/**
 *
 * @author kirill
 */
public class sqlDictionaryReader implements Reader<DictionaryItem>{

    @Override
    public DictionaryItem read(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DictionaryItem[] readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DictionaryItem read(String key, String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ItemForList> getList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
