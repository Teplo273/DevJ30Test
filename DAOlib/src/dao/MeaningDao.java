package dao;

import Dictionary.Meaning;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author kirill
 */
class MeaningDao extends AbstractDao<Meaning> {

    private final String insSql = "INSERT INTO MEANING (TEXT, DATE, AUTHOR) VALUES (?, ?, ?)";
    private final String updSql = "UPDATE MEANING SET (TEXT, DATE, AUTHOR) VALUES (?, ?, ?) WHERE ID = ?";
    private final String delSql = "DELETE FROM MEANING WHERE ID = ?";
    private final String FindIdSql = "SELECT * FROM ITEM WHERE ID = ?";
    private final String FindItemIdSql = "SELECT * FROM ITEM WHERE ITEM_ID = ?";
    
    private PreparedStatement insSt, updSt, delSt, findIdSt, findItemIdSt;
    
    
    public MeaningDao(Connection connection) {
        super(connection);
    }

    @Override
    public void create(Meaning item) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Meaning item) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Meaning findById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
