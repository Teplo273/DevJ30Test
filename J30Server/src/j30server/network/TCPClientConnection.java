package j30server.network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TCPClientConnection implements Runnable {

    private final Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

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
        try {
            while (true) {
                Object inputData = in.readObject();
                if (inputData instanceof String) {
                    String inputString = (String) inputData;
                    System.out.println(inputString);
                    doRequest(inputString);
                    if (inputString.equals("bye")) {
                        socket.close();
                        System.out.println(socket.toString() + "disconected");
                        return;
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(TCPClientConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TCPClientConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private <E extends Serializable> void send(E data) throws IOException {
        out.writeObject(data);
        String status = new StringBuilder().append("отправка: ")
                .append(data.toString())
                .append("назначение: ")
                .append(socket.getRemoteSocketAddress().toString()).toString();
    }
    
    private void doRequest(String request) {
        switch (request) {
            case "bye":
                    break;
            //case ""
                    
        }
    }

}
