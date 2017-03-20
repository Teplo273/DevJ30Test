package j30server.sqlDB.connection;

import java.util.ResourceBundle;

/**
 *
 * @author kirill
 */
class DBConfigImpl implements DBConfig {
    
    private final ResourceBundle resources;

    public DBConfigImpl(ResourceBundle resources) {
        this.resources = resources;
    }
    
    @Override
    public String getUrl() {
        return getProvider() + "://" + getHost() + ":" + getPort();
    }
    
    @Override
    public String getProvider() {
        return resources.getString("database.provider");
    }
    @Override
    public String getHost() {
        return resources.getString("database.host");
    }
    @Override
    public String getPort() {
        return resources.getString("database.port");
    }
    @Override
    public String getName() {
        return resources.getString("database.name");
    }
    @Override
    public String getUser() {
        return resources.getString("database.user");
    }
    @Override
    public String getPassword() {
        return resources.getString("database.password");
    }
    
}
