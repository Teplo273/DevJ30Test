package j30server.network.TCP;

import j30server.sqlDB.Reader;
import j30server.sqlDB.Writer;
import j30server.sqlDB.query.sqlReader;
import j30server.sqlDB.query.sqlWriter;
import transfer.TCPRequests.Request;
import transfer.objects.DictionaryItem;

/**
 *
 * @author kirill
 */
public class RequestDecoder {

    private final ClientConnection connection;
    private Reader reader;
    private Writer writer;

    public RequestDecoder(ClientConnection connection) {
        this.connection = connection;
        writer = new sqlWriter();
        setSqlIo();
    }

    public void doRequest(Request request) {

        switch (request.getType()) {
            case GetList: connection.send(reader.readAll());
                break;
            case FindByName: connection.send(reader.read("word", request.getItem().getWord()));
                break;
            case FindByMeaning:
                break;
            case SaveItem: writer.write(request.getItem());
                break;
            case DeleteItem: writer.delete(request.getId());
                break;
            case Disconnect:
                break;
            default:
        }

    }

    private final void setSqlIo() {
        reader = new sqlReader<DictionaryItem>();
        writer = new sqlWriter<DictionaryItem>();
    }

}
