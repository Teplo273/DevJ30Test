package j30server.network;

import j30server.ServerApp;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TCPServer implements Server {
    
    private final int port = 17777;
    private Thread[] threads = new Thread[5];
    private ServerSocket serverSocket;

    @Override
    public void stopServer() {
        try {
            serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(TCPServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        int i = 0;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                String remoteAdr = clientSocket.getRemoteSocketAddress().toString();
                remoteAdr = remoteAdr.substring(remoteAdr.indexOf('/'));
                System.out.println("Client connected: "
                        + remoteAdr
                        + " on port: "
                        + clientSocket.getLocalPort());

                threads[i] = new Thread(new TCPClientConnection(clientSocket));
                threads[i++].start();
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
