

package j30server.sqlDB.query;

import j30server.sqlDB.Writer;
import java.io.Serializable;
import sql.query.queryGenerators.QueryGenerator;

/**
 *
 * @author kirill
 */
public class sqlWriter<E extends Serializable> implements Writer<E>{
    
    private final QueryGenerator generator;

    public sqlWriter() {
        this.generator = QueryGenerator.getGenerator();
    }
    
    

    @Override
    public void write(E data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String key, String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
