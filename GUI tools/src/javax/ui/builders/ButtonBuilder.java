package javax.ui.builders;

import java.awt.event.ActionListener;
import javax.swing.AbstractButton;

public interface ButtonBuilder<E extends AbstractButton> extends TextCompomentBuilder<E, ButtonBuilder<E>>, ComponentBuilder<E, ButtonBuilder<E>> {
    
    ButtonBuilder<E> setActionCommand(String command);

    ButtonBuilder<E> setActionCommand(Enum command);
    
    ButtonBuilder<E> addActionListener(ActionListener listener);
    
    E build(String text, String command);
    
    E build(String text, Enum command);
}
