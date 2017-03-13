package javax.ui.builders;

import javax.swing.JMenuBar;
import javax.ui.patterns.Builder;

public interface MenuBarBuilder extends Builder<JMenuBar, MenuBarBuilder> {

    MenuBuilder createMenu(String text);
    
}
