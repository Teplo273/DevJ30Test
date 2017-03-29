package j30server.network.TCP;

import j30server.network.TCP.TCPClientConnection;
import j30server.ServerApp;
import j30server.network.Server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TCPServer implements Server {

    private final int port = 17777;
    private final int MaxNumberOfThreads = 5;
    private Thread[] threads = new Thread[MaxNumberOfThreads];
    private ServerSocket serverSocket;
    private int numberOfThread = 0;

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
                
                    newThread(clientSocket);

            }
        } catch (IOException ex) {
            Logger.getLogger(ServerApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void newThread(Socket clientSocket) {
                
        while (numberOfThread >= MaxNumberOfThreads) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TCPServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        threads[numberOfThread] = new Thread(new TCPClientConnection(clientSocket));
        threads[numberOfThread++].start();

    }
    
    public void processEnded() {
        numberOfThread--;
    }

}
