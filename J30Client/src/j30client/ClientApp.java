package j30client;

import j30client.gui.GUI;
import j30client.gui.GUImain;
import j30client.network.TCPconnectorImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import j30client.network.Connector;

public class ClientApp {

    private GUI gui;
    private Connector connector;
    private Object ThreadingObj;
    private InetAddress ip;
    private int port;
    private Socket socket;

    public ClientApp() {
        gui = new GUImain(this, new GUIListener());
        port = 17777;
        try {
            ip = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            Logger.getLogger(ClientApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Create TCPConnect to socket
     *
     * @param socket
     */
    private void createConnection() {
        try {
            Socket socket = new Socket(ip, port);
            connector = new TCPconnectorImpl(socket);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new ClientApp();
    }

    public void setSocket(InetAddress ip, int port) {
        this.ip = ip;
        this.port = port;
        gui.printStatus("server adress is set");
    }

    /**
     * Print servise messege to the log panel
     *
     * @param message
     */
    public void printToMainWindow(String message) {
        gui.printStatus(message);
    }

    /**
     * Run GUI in new Thread with the creation of GUIListener
     */
    class GUIListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Frame action");
            switch (e.getActionCommand()) {
                case "EnterSocket":
                    gui.printStatus("opening option window");
                    gui.OpenOptionFrame();
                    break;
                case "FindByEng":

                    break;
                case "SaveItem":

                    break;
                case "DeleteItem":

                    break;
                case "Connect":
                    if (ClientApp.this.ip == null || ClientApp.this.port == 0) {
                        break;
                    }
                    gui.printStatus("Connecting to " + ip.toString().substring(ip.toString().indexOf('/')) + ": " + port);
                    createConnection();
                    gui.printStatus("Connected");
                    gui.setConnectionLabel(Boolean.TRUE);
                    break;
                case "Disconnect": {
                    connector.disconnect();
                    connector = null;
                    gui.setConnectionLabel(false);
                    gui.printStatus("Disconected");
                    break;
                }
            }

        }

    }
}
