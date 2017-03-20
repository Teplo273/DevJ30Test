package j30server.sqlDB.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author kirill
 */
public class Context implements AutoCloseable {

    private final Connection connection;

    public Context(DBConfig config) throws SQLException {
        this.connection = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());
        System.out.println("Connection to DB " + config.getUrl() + " established.");
    }

    public Context(String propertiesFile) throws SQLException {
        this(DBConfig.getInstance(propertiesFile));
    }
    
    

    public Connection getConnection() {
        return connection;
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }

}
