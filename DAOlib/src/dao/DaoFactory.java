package dao;

import java.sql.Connection;

/**
 *
 * @author kirill
 */
public class DaoFactory {
    
    private static ItemDao instance;

    public static ItemDao getJavaDBdao(Connection connection) {
        return instance == null ? (instance = new ItemDaoImpl(connection)) : instance;
    }
    
}
