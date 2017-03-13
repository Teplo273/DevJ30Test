package javax.ui;

import java.awt.Component;
import java.awt.Window;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.ui.builders.ButtonBuilder;
import javax.ui.builders.factory.UiFactory;
import javax.ui.exceptions.NoResultException;

public abstract class EditorDialog<E> extends AbstractDialog {

    protected JButton okButton;
    
    private E edited;

    public EditorDialog(Window owner) {
        super(owner);
    }
    
    public EditorDialog(Window owner, E edited) {
        super(owner);
        this.edited = edited;
    }
    
    protected E getEdited() {
        return edited;
    }
    
    protected void setEdited(E value) {
        edited = value;
    }
    
    public E showDialog() throws NoResultException {
        setVisible(true);
        if (edited == null) throw new NoResultException();
        return edited;
    }
    
    protected int getDefaultContainerGap() {
        JComponent pane = (JComponent) getContentPane();
        return LayoutStyle.getInstance().getContainerGap(pane, SwingConstants.WEST, pane);
    }
    
    protected Component createDefaultButtonsPanel() {
        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel(layout);
        int gap = getDefaultContainerGap();
        ButtonBuilder<JButton> builder = UiFactory.buttonBuilder().addActionListener(this);
        JButton cancelButton = builder.build("Cancel", DialogCommand.Cancel);
        panel.add(cancelButton);
        layout.putConstraint(SpringLayout.EAST, cancelButton, -gap, SpringLayout.EAST, panel);
        layout.putConstraint(SpringLayout.NORTH, cancelButton, gap, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.SOUTH, panel, gap, SpringLayout.SOUTH, cancelButton);
        okButton = builder.setEnabled(false).build("OK", DialogCommand.OK);
        panel.add(okButton);
        layout.putConstraint(SpringLayout.WEST, okButton, gap, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, okButton, gap, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.SOUTH, panel, gap, SpringLayout.SOUTH, okButton);
        return panel;
    }

}
