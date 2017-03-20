/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j30server.sqlDB.connection;

import java.util.ResourceBundle;

/**
 *
 * @author kirill
 */
public interface DBConfig {

    String getHost();

    String getName();

    String getPassword();

    String getPort();

    String getProvider();

    String getUrl();

    String getUser();
    
    public static DBConfig getInstance(String resources) {
        return new DBConfigImpl(ResourceBundle.getBundle(resources));
    }
    
}
