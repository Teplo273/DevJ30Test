package javax.ui.builders.factory.base;

import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.ui.builders.ButtonBuilder;

public abstract class AbstractButtonBuilder<E extends AbstractButton> 
                extends AbstractComponentBuilder<E, ButtonBuilder<E>> 
                implements ButtonBuilder<E>{

    @Override
    public AbstractButtonBuilder<E> setActionCommand(String command) {
        source.setActionCommand(command);
        return this;
    }

    @Override
    public AbstractButtonBuilder<E> setActionCommand(Enum command) {
        return setActionCommand(command.name());
    }
    
    @Override
    public AbstractButtonBuilder<E>  addActionListener(ActionListener listener) {
        source.addActionListener(listener);
        return this;
    }
    
    @Override
    public AbstractButtonBuilder<E>  setText(String text) {
        source.setText(text);
        return this;
    }

    @Override
    public E build(String text, Enum command) {
        return setText(text).setActionCommand(command).build();
    }

    @Override
    public E build(String text, String command) {
        return setText(text).setActionCommand(command).build();
    }
    
    @Override
    public E build() {
        final E obj = super.build();
        obj.setText(source.getText());
        obj.setActionCommand(source.getActionCommand());
        for (ActionListener listener : source.getActionListeners()) {
            obj.addActionListener(listener);
        }
        notifyBuild(obj);
        return obj;
    }
    
}
