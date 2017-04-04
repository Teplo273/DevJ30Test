package j30server;

import j30server.DBconnection.Context;
import j30server.network.TCP.TCPServer;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerApp {

    private final String propertiesFile = "j30server.resources.database";

    public static void main(String... args) {

        new ServerApp();

    }

    public ServerApp() {
        Connection dbConnection;
        try {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ServerApp.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("Postgress driver not found.");
                return;
            }
            dbConnection = Context.getConnection(propertiesFile);
            RequestDecoder requestDecoder = new RequestDecoder(dbConnection);
            TCPServer tcpServer = new TCPServer(requestDecoder);
            tcpServer.run();
        } catch (SQLException ex) {
            Logger.getLogger(ServerApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
