package j30client.gui;

import j30client.ClientApp;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import static javax.swing.ListSelectionModel.SINGLE_SELECTION;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.ui.builders.MenuBarBuilder;
import javax.ui.builders.factory.UiFactory;

public class GUImain extends JFrame implements GUI {

    public GUImain(ClientApp app, ActionListener listener) {
        
        this.app = app;

        System.out.println("gui building");

        this.listener = listener;
        initFrame();
        initCenter();
        initNorth();
        initSouth();
        pack();
        setVisible(true);

        printStatus("Main window build!");
    }

    private final ClientApp app;
    private JLabel connectionLabel;
    private DefaultListModel listModel = new DefaultListModel();
    private JScrollPane scrollPane;
    private JList logList;
    private ActionListener listener;

    private void initFrame() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignore) {
        }

        setLocationByPlatform(true);
        setPreferredSize(new Dimension(200, 300));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        printStatus("Frame initialized");
    }

    private void initNorth() {

        MenuBarBuilder BarBuilder = UiFactory.menuBarBuilder(listener);

        JMenu menu = BarBuilder
                .createMenu("Connection")
                .addItem("Socket", Command.EnterSocket)
                .addItem("Connect", Command.Connect)
                .addItem("Disconnect", Command.Disconnect)
                .build();

        this.getContentPane().add(BarBuilder.build(), NORTH);
        printStatus("North initialized");
    }

    private void initCenter() {

        logList = new JList(listModel);
        logList.setSelectionMode(SINGLE_SELECTION);
        logList.setCellRenderer(new StatusTextCellRenderer());

        scrollPane = new JScrollPane(logList);
        scrollPane.setPreferredSize(new Dimension(200, 200));
        this.getContentPane().add(scrollPane, CENTER);
    }

    private void initSouth() {
        connectionLabel = new JLabel();
        connectionLabel.setBorder(BorderFactory.createBevelBorder(0));
        connectionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        connectionLabel.setBackground(Color.DARK_GRAY);
        connectionLabel.setOpaque(true);
        this.getContentPane().add(connectionLabel, SOUTH);
        setConnectionLabel(false);
        printStatus("South initialized");
    }

    @Override
    public void setConnectionLabel(Boolean isConnected) {
        connectionLabel.setText((isConnected ? "Online" : "OffLine"));
        connectionLabel.setForeground((isConnected ? Color.GREEN : Color.RED));
    }

    @Override
    public void printStatus(String message) {
        System.out.println(message);
        listModel.addElement(message);
        //if (this.isVisible()) {
        //  System.out.println("Renew");
        //scrollPane.invalidate();
        //this.invalidate();
        //this.repaint();
        //this.validate();
        //}

    }
    
    public void OpenOptionFrame() {
        new OptionFrame(app);
    }
    
}
