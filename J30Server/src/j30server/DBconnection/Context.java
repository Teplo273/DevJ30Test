package j30server.DBconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author kirill
 */
public interface Context extends AutoCloseable {

    public static Connection getConnection(String propertiesFile) throws SQLException {
        return new ContextImpl(propertiesFile).getConnection();
    }

}

class ContextImpl implements Context {

    private final Connection connection;

    ContextImpl(DBConfig config) throws SQLException {
        this.connection = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());
        System.out.println("Connection to DB " + config.getUrl() + " established.");
    }

    ContextImpl(String propertiesFile) throws SQLException {
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
