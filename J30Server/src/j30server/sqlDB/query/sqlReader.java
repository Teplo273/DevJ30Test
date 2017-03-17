package j30server.sqlDB.query;

import j30server.sqlDB.Reader;
import java.io.Serializable;
import sql.query.queryGenerators.QueryGenerator;
import java.util.ArrayList;

/**
 *
 * @author kirill
 */
public class sqlReader<E extends Serializable> implements Reader<E>{
    
    private final QueryGenerator generator;

    public sqlReader() {
        this.generator = QueryGenerator.getGenerator();
    }
    
    

    @Override
    public E read(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E[] readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E read(String key, String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList getList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
