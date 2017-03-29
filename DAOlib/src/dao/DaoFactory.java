package dao;

import java.sql.Connection;

/**
 *
 * @author kirill
 */
public interface DaoFactory {

    public static ItemDao getJavaDBdao(Connection connection) {
        return new ItemDao(connection);
    }

}
