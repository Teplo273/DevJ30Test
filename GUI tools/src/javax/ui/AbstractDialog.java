package javax.ui;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public abstract class AbstractDialog extends JDialog implements ActionListener {

    private boolean isInitialized;

    public AbstractDialog(Window owner) {
        super(owner);
        setModal(true);
    }

    @Override
    public void setVisible(boolean isVisible) {
        if (isVisible && !isInitialized) {
            isInitialized = true;
            initComponents();
            pack();
        }
        super.setVisible(isVisible);
    }

    protected void initComponents() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        onCommand(DialogCommand.valueOf(e.getActionCommand()));
    }

    protected void onCommand(DialogCommand command) {
    }

}
