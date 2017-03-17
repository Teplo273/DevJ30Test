package j30server.network.TCP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.TCPRequests.Request;

public class TCPClientConnection implements ClientConnection {

    private final Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private RequestDecoder decoder;

    public TCPClientConnection(Socket socket) {
        this.socket = socket;
        try {
            this.in = new ObjectInputStream(socket.getInputStream());
            this.out = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(TCPClientConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        decoder = new RequestDecoder(this);
        try {
            while (true) {
                Object inputData = in.readObject();
                if (inputData instanceof Request) {
                    decoder.doRequest((Request) inputData);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(TCPClientConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TCPClientConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public <E extends Serializable> void send(E data) {
        try {
            out.writeObject(data);
        } catch (IOException ex) {
            Logger.getLogger(TCPClientConnection.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        String status = new StringBuilder().append("отправка: ")
                .append(data.toString())
                .append("назначение: ")
                .append(socket.getRemoteSocketAddress().toString()).toString();
    }
    
}
