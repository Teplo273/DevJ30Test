package javax.ui.builders;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public interface MenuBuilder extends TextCompomentBuilder<JMenu, MenuBuilder>{

    MenuBuilder addItem(JMenuItem item);
    
    MenuBuilder addItem(String text, Enum command);
    
    JPopupMenu buildPopup();
    
}
