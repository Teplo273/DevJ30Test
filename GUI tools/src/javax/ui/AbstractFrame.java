package javax.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import static javax.swing.UIManager.getSystemLookAndFeelClassName;
import static javax.swing.UIManager.setLookAndFeel;
import javax.swing.UnsupportedLookAndFeelException;

public abstract class AbstractFrame<E extends Enum<E>> extends JFrame implements ActionListener {

    private final Class<E> cls;
    
    private boolean isInitialized;

    public static void initLookAndFeel() {
        try {
            setLookAndFeel(getSystemLookAndFeelClassName());
        } catch(ReflectiveOperationException | UnsupportedLookAndFeelException e) {
            e.printStackTrace(System.err);
        }
    }
    
    public AbstractFrame(Class<E> cls) {
        this.cls = cls;
    }

    @Override
    public void setVisible(boolean isVisible) {
        if (isVisible && !isInitialized) {
            initComponents();
            pack();
            isInitialized = true;
        }
        super.setVisible(isVisible);
    }
    
    protected void initComponents() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        onCommand(E.valueOf(cls, e.getActionCommand()));
    }

    protected void onCommand(E command) {}
    
}
