package j30server;

import dao.DaoFactory;
import dao.ItemDao;
import j30server.network.TCP.ClientConnection;
import java.sql.Connection;
import transfer.TCPRequests.Request;

/**
 *
 * @author kirill
 */
public class RequestDecoder {

    private final ItemDao dao;
    private final Connection dbConnetcion;
    

    public RequestDecoder(Connection dbConnection) {
        this.dbConnetcion = dbConnection;
        dao = DaoFactory.getJavaDBdao(dbConnection);
    }

    public static synchronized void doRequest(Request request, ClientConnection client) {

        switch (request.getType()) {
            case GetList: //connection.send(reader.readAll());
                break;
            case FindItem: //connection.send();
                break;
            case SaveItem: //writer.write(request.getItem());
                break;
            case DeleteItem: //writer.delete(request.getId());
                break;
            case Disconnect:
                break;
            default:
        }

    }

}
