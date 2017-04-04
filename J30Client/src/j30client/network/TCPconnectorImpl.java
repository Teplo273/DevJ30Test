package j30client.network;

import Dictionary.Item;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.LinkedList;
import transfer.TCPRequests.ClientRequests.ClientRequestType;

public class TCPconnectorImpl implements Connector<Item> {


    private final Socket socket;
    private final ObjectOutputStream out;
    private LinkedList<TCPListener> listeners = new LinkedList<>();

    public TCPconnectorImpl(Socket socket) throws IOException {
        this.socket = socket;
        out = new ObjectOutputStream(socket.getOutputStream());
    }

    public TCPconnectorImpl(InetAddress address, int port) throws IOException {
        this(new Socket(address, port));
    }

    
    private void send(ClientRequestType data) throws IOException {
        out.writeObject(data);
        String status = new StringBuilder().append("отправка: ")
                .append(data.toString())
                .append("назначение: ")
                .append(socket.getRemoteSocketAddress().toString()).toString();
    }

    @Override
    public void disconnect() {
        try {
            socket.close();
        } catch (IOException ignore){}
    }

    @Override
    public Item findByWord(String word) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void findByMeaning(String meaning) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveItem(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteItem(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    



}
