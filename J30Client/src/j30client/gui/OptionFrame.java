package j30client.gui;

import j30client.ClientApp;
import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class OptionFrame extends JFrame{
    
    private static OptionFrame instance = null;
    
    private JTextField ipField;
    private JTextField portField;
    private JTextField nameField;
    private JPanel contentPane;
    private Socket socket;
    private final ClientApp app;
    
    
    
    public static OptionFrame getInstance(ClientApp app) {
        return (instance == null) ? instance = new OptionFrame(app) : instance;
    }

    public OptionFrame(ClientApp app) {
        
        this.app = app;
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignore) {
        }

        setLocationByPlatform(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        initContentPane();
        
        initContent();
        //setPreferredSize(new Dimension(200, 300));
        pack();
        setVisible(true);
    }

    private void initContent() {
        initNameField();
        initIpField();
        initPortField();
        initButton();
    }
    

    private void initContentPane() {
        contentPane = new JPanel(new GridLayout(3, 2));
        this.getContentPane().add(contentPane, CENTER);
    }
    
    private void initIpField() {
        ipField = new JTextField("127.0.0.1");
        ipField.setBorder(BorderFactory.createEmptyBorder());
        contentPane.add(new JLabel("IP"));
        contentPane.add(ipField);
    }

    private void initPortField() {
        portField = new JTextField("17777");
        contentPane.add(new JLabel("Port"));
        contentPane.add(portField);
    }

    private void initNameField() {
        nameField = new JTextField("localhost");
        contentPane.add(new JLabel("Name"));
        contentPane.add(nameField);
    }
    
    public InetAddress getIP() throws UnknownHostException {
        return InetAddress.getLocalHost();
        /**
        if (checkIP()) {
            return ipField.getText().trim();
        }
        throw new WrongIPException(ipField.getText());
        **/
    }
    
    public int getPort() {
        return Integer.parseInt(portField.getText().trim());
    }
    
    private boolean checkIP(){
        /**
        Pattern ipFrom = Pattern.compile(CENTER);
        String ip = ipField.getText().trim();
        String[] splitedIP = ip.split(".");
        if (splitedIP.length == 4) {
           
            return ip;
        }
        throw new RuntimeException();
        **/
        return true;
    }

    private void initButton() {
        JButton button = new JButton("SET");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    app.setSocket(getIP(), getPort());
                    OptionFrame.this.dispose();
                } catch (IOException ex) {
                    System.out.println("11" + ex.getMessage());
                }
                
            }
        });
        add(button, BorderLayout.SOUTH);
    }


}
