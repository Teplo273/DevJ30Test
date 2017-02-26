
package j30client.gui;

import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class StatusTextCellRenderer extends JLabel implements ListCellRenderer{

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        
        setText(value.toString());
        setBorder(BorderFactory.createEmptyBorder(1, 5, 1, 5));
        setAlignmentY(CENTER);
        return this;
    }
    
    

}
